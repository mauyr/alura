package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.model.Autor;
import br.com.caelum.livraria.model.Usuario;
import br.com.caelum.livraria.util.RedirectView;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class LoginBean {

    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public String efetuaLogin() {
        System.out.println("Fazendo login do usuário "
                + this.usuario.getEmail());

        boolean existe = new UsuarioDao().existe(this.usuario);

        if (existe) {
            return "livro?faces-redirect=true";
        }

        return null;
    }
}
