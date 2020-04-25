package com.company.project.realm;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		//若是使用了分页,这里不要查询数据库,会导致分页作用再这里
//		String username = (String) principals.getPrimaryPrincipal();
		String username = "joker";
		if (username == null) {
			throw new AuthenticationException("token invalid");
		}
//		List<Role> roles = (List<Role>) SecurityUtils.getSubject().getSession().getAttribute("roles");
		List<String> roles = new ArrayList<>();
		roles.add("god");
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Set<String> permissionRoles = new HashSet<>();
		for(String role:roles){
			permissionRoles.add(role);
			List<String> permissions = new ArrayList<>();
			permissions.add("STW");
			for(String permission:permissions){
				simpleAuthorizationInfo.addStringPermission(permission); // 添加权限
			}
		}
		simpleAuthorizationInfo.setRoles(permissionRoles);
		return simpleAuthorizationInfo;
	}

	/**
	 * 权限认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) {
		String username = (String)auth.getPrincipal();
		if (username == null) {
			throw new AuthenticationException("token invalid");
		}
//		UserRole userRoleDTO = userRoleService.findByUsername(username);
		String userRole = new String();
		if (userRole == null) {
			throw new UnknownAccountException("User didn't existed!");
		}
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("uid",1);
		session.setAttribute("username","joker");
		session.setAttribute("roles","god");
		return new SimpleAuthenticationInfo("admin","admin","xxx");
	}

}
