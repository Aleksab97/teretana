/*
 * package testTeretana;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Filter; import javax.servlet.FilterChain; import
 * javax.servlet.ServletException; import javax.servlet.ServletRequest; import
 * javax.servlet.ServletResponse; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component;
 * 
 * import testTeretana.domain.Operater; import
 * testTeretana.service.TokenService;
 * 
 * @Component public class SecurityFilter implements Filter {
 * 
 * @Autowired private TokenService tokenService;
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletResponse httpResponse = (HttpServletResponse) response;
 * HttpServletRequest httpRequest = (HttpServletRequest) request;
 * 
 * httpResponse.addHeader("Access-Control-Allow-Origin", "*");
 * httpResponse.addHeader("Access-Control-Allow-Methods",
 * "GET,PUT,PATCH,DELETE,POST,OPTIONS");
 * httpResponse.addHeader("Access-Control-Max-Age", "3600");
 * httpResponse.addHeader("Access-Control-Allow-Headers",
 * "Origin, x-requested-with, X-AUTH-TOKEN, Content-Type, Accept");
 * 
 * if(httpRequest.getRequestURI().contains("/auth")) { chain.doFilter(request,
 * response); } else { String token = httpRequest.getHeader("X-AUTH-TOKEN");
 * if(token == null) { httpResponse.setStatus(401); return; } Operater operater
 * = tokenService.getOperaterFromToken(token);
 * httpRequest.setAttribute("OPERATER", operater); chain.doFilter(request,
 * response);
 * 
 * }
 * 
 * }
 * 
 * }
 */