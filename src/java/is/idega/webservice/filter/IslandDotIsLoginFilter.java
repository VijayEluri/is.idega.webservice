package is.idega.webservice.filter;

import is.idega.idegaweb.egov.accounting.business.CitizenBusiness;
import is.idega.webservice.business.IslandDotIsService;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.ejb.FinderException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.idega.business.IBOLookup;
import com.idega.core.accesscontrol.business.LoginBusinessBean;
import com.idega.core.builder.business.BuilderService;
import com.idega.core.builder.business.BuilderServiceFactory;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.idegaweb.IWMainApplication;
import com.idega.presentation.IWContext;
import com.idega.servlet.filter.BaseFilter;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.Group;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;

public class IslandDotIsLoginFilter extends BaseFilter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse response = (HttpServletResponse) sresponse;

		IWContext iwc = new IWContext(request, response, request.getSession()
				.getServletContext());
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(iwc.getServletContext());
		IslandDotIsService service = (IslandDotIsService) springContext
				.getBean("islandDotIsService");

		String URI = request.getRequestURI();
		String token = iwc.getParameter("token");
		if (token != null && !"".equals(token.trim())
				&& URI.indexOf("innskraningislanddotis") != -1) {
			String personalID = service.getPersonalIDFromToken(token,
					iwc.getRemoteIpAddress());
			if (personalID != null && !"".equals(personalID.trim())) {
				LoginBusinessBean loginBusiness = getLoginBusiness(request);
				boolean isLoggedOn = loginBusiness.isLoggedOn(request);
				try {
					if (isLoggedOn) {
						loginBusiness.logOutUser(iwc);
					}

					IWMainApplication iwMainApplication = getIWMainApplication(request);
					IWApplicationContext iwac = iwMainApplication
							.getIWApplicationContext();
					UserBusiness userBusiness = (UserBusiness) IBOLookup
							.getServiceInstance(iwac, UserBusiness.class);
					CitizenBusiness citizenBusiness = (CitizenBusiness) IBOLookup
							.getServiceInstance(iwac, CitizenBusiness.class);

					// check if user has login, otherwise create a login and put
					// in default group
					if (!loginBusiness.hasUserLogin(request, personalID)) {
						User user = userBusiness.getUser(personalID);
						userBusiness.generateUserLogin(user);
						Group acceptedCitizens;
						try {
							acceptedCitizens = citizenBusiness
									.getRootAcceptedCitizenGroup();
							acceptedCitizens.addGroup(user,
									IWTimestamp.getTimestampRightNow());
							if (user.getPrimaryGroup() == null) {
								user.setPrimaryGroup(acceptedCitizens);
								user.store();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					loginBusiness.logInByPersonalID(iwc, personalID);
					HttpSession session = request.getSession();
					User user = loginBusiness.getCurrentUser(session);

					int redirectPageId = userBusiness
							.getHomePageIDForUser(user);

					if (redirectPageId > 0) {
						response.sendRedirect(getBuilderService(iwac)
								.getPageURI(redirectPageId));
					}
				} catch (FinderException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		chain.doFilter(srequest, sresponse);
	}

	protected BuilderService getBuilderService(IWApplicationContext iwac)
			throws RemoteException {
		return BuilderServiceFactory.getBuilderService(iwac);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * protected com.idega.user.business.UserBusiness getUserBusiness(
	 * IWApplicationContext iwac) throws RemoteException { return
	 * (com.idega.user.business.UserBusiness) IBOLookup
	 * .getServiceInstance(iwac, com.idega.user.business.UserBusiness.class); }
	 */
}