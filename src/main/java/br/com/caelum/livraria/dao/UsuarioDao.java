package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.model.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.Serializable;

/**
 * Created by mauyr on 17/01/17.
 */
public class UsuarioDao implements Serializable {

    @Inject
    EntityManager em;

    public boolean existe(Usuario usuario) {

        TypedQuery<Usuario> query = em
                .createQuery(
                        "select u from Usuario u where u.email = :pEmail and u.senha = :pSenha",
                        Usuario.class);

        query.setParameter("pEmail", usuario.getEmail());
        query.setParameter("pSenha", usuario.getSenha());

        try {
            Usuario resultado = query.getSingleResult();
            resultado.getId();
        } catch (NoResultException ex) {
            return false;
        }

        return true;
    }
}
