Spring Security Code snippet and explanation

default: when we add spring security dependency all apis are ask authentication
       default username: user password: generates when we run the project can be
     used to authorize the apis
      while sending the request
       
customizing the security: before spring security 6
 @configuration
 @EnableWebSecurity
 public class SecurityConfig extends WebSecuirtyConfigurerAdapter{

     @Override
     protected void configre(HttpSecurity http) throws Exception{
          http
               .authorizeRequests()
                    .antMatchers("/hello").permitAll()
                    .anyRequest().authenticated()
               .and
               .formLogin()
     }
 }

 @EnableWebSecurity: to customize the spring security
                WebSecurityConfigurerAdapter is a utility class in the
               spring security framework that provides default
               configuration and allows customization of certain
                features it.

configre(HttpSecurity http): method provides a way to configre how request are secured. it defines how
                              request matching should be done and what security actions should be applied.


http.authorizeRequest(): this tells spring security to start authorize the requests.

.antMatchers("/hello").permitAll(): this parts specifies that Http request matching path "/hello" should be permitted
                                   all the users, whether they are authenticated or not.

.anyRequest().authenticated(): this is a more general matchers that specifies any request which not matched by previous matchers 
                              eg. "/hello" should be authenticated, meaning users have to provide valid creadentials to access
                              these endpoints

.and(): this is a method to join several configurations. it helps to continue the configuration from the root (HttpSecurity)

.formLogin(): This enables form-based authentication. By default, it will provide a form the user to enter their username and password.
               if the user is not authenticated and they try to access a secured endpoint, they'll be redirected to the defualt login form.

http.csrf().disabled(): csrf (cross site reuqest forgery) if its enabled, Spring Security expects a csrf token through request which we are sending 
                         if its enabled and we are not sending csrf token 403 Forbiden error with through by server


Basic authentication (by username and password): is stateless means, we have provide username and password every time with endpoint which are
                                                  needs to be authenticate.
     To resolve this some applcation uses session management with basic authentication.

when you log in with Spring Security, it manages your authentication across multiple requests, despite HTTP being stateless.

1. Session Creation: After successful authentication, an Http session is formed. your authentication details are stored in this session.
2. Session Cookie: A JSESSIONID cookie is sent to your browser, which gets sent back with subsequent requests helping the server recognize your session.
3. SecurityContext: Using the JSESSIONID, Spring Security fetches your authentication details for each request.
4. Session Timeout: Sessions have a limited life. if you're inactive past this limit, you're  logged out.
5. Logout: When logging out, your session ends, and the related cookie is removed.
6. Remember-Me: Spring Security can remember you even after session ends using differen tcookie (typically have a longer lifeSpan). 

in essance, Spring Security leverages sessions and cookies, mainly JSESSIONID, to ensure you remains authenticated acorss requests

