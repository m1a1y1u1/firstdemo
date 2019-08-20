//package com.springcloud.microsso.config.oauth2;
//
//import com.springcloud.microsso.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//
///**
// * 开启授权服务功能
// *
// * @data: Created in 2019/8/14 10:18
// * @author: <a href="may@drore.com">马雨</a>
// */
//@Configuration
//@EnableAuthorizationServer
//public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//    /**
//     * 将Token存储在内存中
//     *  private TokenStore tokenStore = new InMemoryTokenStore();
//     */
//    private JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
////    private TokenStore tokenStore = new InMemoryTokenStore();
//
//    @Autowired
//    @Qualifier
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private UserService userService;
//
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        //ClientDetailsServiceConfigurer配置了客户端的一些基本信息
//        clients.inMemory() //将客户端的信息存储在内存中
//                .withClient("browser") //创建了一个client名为browser的客户端
//                .authorizedGrantTypes("refresh_token", "password")//配置验证类型
//                .scopes("ui")//配置客户端域为“ui”
//                .and()
//                .withClient("auto-test")
//                .secret("123456")
//                .authorizedGrantTypes("client_credentials", "refresh_token", "password")
//                .scopes("server");
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .tokenStore(tokenStore) //Token的存储方式为内存
//                .authenticationManager(authenticationManager) //WebSecurity配置好的
//                .userDetailsService(userService);//读取用户的验证信息
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//        //配置获取Token的策略
//        oauthServer
//                .tokenKeyAccess("permitAll()") //对获取Token的请求不再拦截
//                .checkTokenAccess("isAuthenticated()"); //验证获取Token的验证信息
//
//    }
//}