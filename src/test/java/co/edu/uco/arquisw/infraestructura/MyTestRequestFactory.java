package co.edu.uco.arquisw.infraestructura;

import co.edu.uco.arquisw.infraestructura.seguridad.constante.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class MyTestRequestFactory {
    public static MockHttpServletRequestBuilder myFactoryRequestAuthenticatedGetOne(String url, int id, String role) {
        return MockMvcRequestBuilders.get(url,id)
                .header("Authorization", getJwt(role));
    }
    public static MockHttpServletRequestBuilder myFactoryRequestAuthenticatedGet(String url, String role) {
        return MockMvcRequestBuilders.get(url)
                .header("Authorization", getJwt(role));
    }


    public static MockHttpServletRequestBuilder myFactoryRequestAuthenticatedDelete(String url, int id, String role) {
        return MockMvcRequestBuilders.delete(url,id)
                .header("Authorization", getJwt(role));
    }

    public static  MockHttpServletRequestBuilder myFactoryRequestAuthenticatedPut(String url, long id, String role) {
        return MockMvcRequestBuilders.put(url,id)
                .header("Authorization", getJwt(role));
    }

    public static MockHttpServletRequestBuilder myFactoryRequestAuthenticatedPostId(String url, long id, String role) {
        return MockMvcRequestBuilders.post(url,id)
                .header("Authorization", getJwt(role));
    }

    public static MockHttpServletRequestBuilder myFactoryRequestAuthenticatedPost(String url, String role) {
        return MockMvcRequestBuilders.post(url)
                .header("Authorization", getJwt(role));
    }

    public static String getJwt(String role) {
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder().setIssuer("UCO").setSubject("JWT Token")
                .claim("username", "juan@gmail.com")
                .claim("authorities", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 30000000))
                .signWith(key).compact();
        return jwt;
    }

}
