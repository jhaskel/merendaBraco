package com.doisbitsw.licencas.api.infra.security;


import com.doisbitsw.licencas.api.infra.cors.CorsConfig;
import com.doisbitsw.licencas.api.infra.security.jwt.JwtAuthenticationFilter;
import com.doisbitsw.licencas.api.infra.security.jwt.JwtAuthorizationFilter;
import com.doisbitsw.licencas.api.infra.security.jwt.handler.AccessDeniedHandler;
import com.doisbitsw.licencas.api.infra.security.jwt.handler.UnauthorizedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private UnauthorizedHandler unauthorizedHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authManager = authenticationManager();

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/users","/email","/api/v1/login","/api/v1/usuarios","/sendmail/{email}","/api/v1/email","/api/v2/carros","/api/v1/escolas","/api/v1/itens/total/{ano}","/api/v1/itens/totalLimpeza/{ano}","/api/v1/escolas/quantAlunos","/api/v1/itens/tradicional/{ano}","/api/v1/itens/familiar/{$ano}","/api/v1/pnae/soma/{$ano}","/api/v1/pedidos/pedidoSemAf","/api/v1/af/afEnviada","/api/v1/totalMesEscola/{escola}/{ano}","/api/v1/totalCategoriaEscola/{escola}/{ano}","/api/v1/itens/totalEscolas/{ano}","/api/v1/itens/mediaAlunos/{ano}","/api/v1/itens/totalCategoriaEscola/{escola}/{ano}","/api/v1/itens/totalMesEscola/{escola}/{ano}","/api/v1/itens/totalMes/{ano}","/api/v1/itens/totalCategoria/{ano}","/api/v1/escola/quantidade","/api/v1/itens/totalEscola/{escola}/{ano}","/api/v1/itens/totalEscolaLimpeza/{escola}/{ano}","/api/v1/escolas/quantAlunosEscola/{id}","/api/v1/itens/tradicionalEscola/{escola}/{ano}","/api/v1/itens/familiarEscola/{escola}/{ano}")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/usuarios","/email","/api/v1/empreendedor","/api/v1/carros")
                .permitAll()
                .antMatchers(HttpMethod.PUT,"/api/v1/usuarios/{$id}","/api/v1/empreendedor/{$id}")
                .permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .addFilter(new CorsConfig())
                .addFilter(new JwtAuthenticationFilter(authManager))
                .addFilter(new JwtAuthorizationFilter(authManager, userDetailsService))
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

}
