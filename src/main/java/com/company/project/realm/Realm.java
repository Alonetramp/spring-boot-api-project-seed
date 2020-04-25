package com.company.project.realm;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;


/**
 * 自定义Realm
 * @author jude
 *
 */
public class Realm extends AuthorizingRealm {


//	/**
//	 * JWT大坑！，必须重写此方法，不然Shiro会报错
//	 */
//	@Override
//	public boolean supports(AuthenticationToken token) {
//		return token instanceof JWTToken;
//	}
//
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username = (String) principals.getPrimaryPrincipal();
//		if (username == null) {
//			throw new AuthenticationException("token invalid");
//		}
//		List<Role> roles = (List<Role>) SecurityUtils.getSubject().getSession().getAttribute("roles");
//		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//		Set<String> permissionRoles = new HashSet<>();
//		for(Role role:roles){
//			permissionRoles.add(role.getName());
//			List<Menu> menuList=menuRepository.findByRoleId(role.getId());
//			for(Menu menu:menuList){
//				simpleAuthorizationInfo.addStringPermission(menu.getName()); // 添加权限
//			}
//		}
//		simpleAuthorizationInfo.setRoles(permissionRoles);
//		return simpleAuthorizationInfo;

		return null;
	}

	/**
	 * 权限认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) {
//		String username = (String)auth.getPrincipal();
//		if (username == null) {
//			throw new AuthenticationException("token invalid");
//		}
//		UserRoleDTO userRoleDTO = userRoleService.findByUsername(username);
//		if (userRoleDTO == null) {
//			throw new UnknownAccountException("User didn't existed!");
//		}
//		Session session = SecurityUtils.getSubject().getSession();
//		session.setAttribute("uid",userRoleDTO.getId());
//		session.setAttribute("username",userRoleDTO.getUsername());
//		session.setAttribute("companyId",userRoleDTO.getCompanyId());
//		session.setAttribute("roles",userRoleDTO.getRoleList());
//		return new SimpleAuthenticationInfo(userRoleDTO.getAccount(),userRoleDTO.getPassword(),"xxx");

		return null;
	}

}
