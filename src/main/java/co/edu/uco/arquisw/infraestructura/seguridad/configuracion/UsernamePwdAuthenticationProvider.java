package co.edu.uco.arquisw.infraestructura.seguridad.configuracion;

import co.edu.uco.arquisw.aplicacion.usuario.consulta.ConsultarPersonaPorCorreo;
import co.edu.uco.arquisw.dominio.transversal.utilitario.TextoConstante;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.dto.RolDTO;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.entidad.UsuarioEntidad;
import co.edu.uco.arquisw.infraestructura.usuario.adaptador.repositorio.jpa.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsernamePwdAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private ConsultarPersonaPorCorreo consultarPersonaPorCorreo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		UsuarioEntidad usuario = usuarioDAO.findByCorreo(username);
		PersonaDTO persona= this.consultarPersonaPorCorreo.ejecutar(username);

		if (usuario!=null) {
			if (passwordEncoder.matches(pwd, usuario.getClave())) {
				return new UsernamePasswordAuthenticationToken(username, pwd, getGrantedAuthorities(persona.getRoles()));
			} else {
				throw new BadCredentialsException("Invalid password!");
			}
		}else {
			throw new BadCredentialsException("No user registered with this details!");
		}
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(List<RolDTO> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (RolDTO authority : authorities) {
			addCrudPrivilage(grantedAuthorities,authority);
        	grantedAuthorities.add(new SimpleGrantedAuthority(authority.getNombre()));
        }

        return grantedAuthorities;
    }

	private boolean haveReadPrivilege(List<GrantedAuthority> grantedAuthorities){
		return grantedAuthorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(TextoConstante.LECTURA));
	}
	private boolean haveWritePrivilege(List<GrantedAuthority> grantedAuthorities){
		return grantedAuthorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(TextoConstante.ESCRITURA));
	}
	private boolean haveUpdatePrivilege(List<GrantedAuthority> grantedAuthorities){
		return grantedAuthorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(TextoConstante.ACTUALIZACION));
	}

	private boolean haveDeletePrivilege(List<GrantedAuthority> grantedAuthorities){
		return grantedAuthorities.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(TextoConstante.ELIMINACION));
	}

	private void addCrudPrivilage(List<GrantedAuthority> grantedAuthorities,RolDTO authority){
		if(authority.isLeer()&&!haveReadPrivilege(grantedAuthorities))
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(TextoConstante.LECTURA));
		}
		if(authority.isEscribir()&&!haveWritePrivilege(grantedAuthorities))
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(TextoConstante.ESCRITURA));
		}
		if(authority.isActualizar()&&!haveUpdatePrivilege(grantedAuthorities))
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(TextoConstante.ACTUALIZACION));
		}
		if(authority.isActualizar()&&!haveDeletePrivilege(grantedAuthorities))
		{
			grantedAuthorities.add(new SimpleGrantedAuthority(TextoConstante.ELIMINACION));
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
	}
}