package learn.configurations.RequestConfigs;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@SuppressWarnings("null")
public class RequestAnalyser extends OncePerRequestFilter {

    private static final long MAX_TIME = 0; // 30 sec

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } finally {
            long duration = System.currentTimeMillis() - start;
            String message = request.getMethod() + " " + request.getRequestURI() + " " + response.getStatus() + " "
                    + (duration / 1000) + "s";
            if (duration > MAX_TIME) {
                log.warn(message);
            } else {
                log.info(message);
            }
        }

    }

}