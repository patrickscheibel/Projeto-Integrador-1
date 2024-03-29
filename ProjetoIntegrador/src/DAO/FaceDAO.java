/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.Ambiente;
import Entidade.Camada;
import Entidade.Face;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIFrameAmbiente;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author patrick.scheibel
 */
public class FaceDAO extends DAO{
    
    public void SalvarFace(Face face, JIFrameAmbiente jIFrameProjeto, Usuario usuario){
        JIFrameAmbiente jif = jIFrameProjeto;
        if(!face.getDescricao().isEmpty() && face.getMetrosQuadrado() > 0 && face.getResistenciaInterna() > 0 && face.getResistenciaExterna() > 0){
            if(face.getId() == null){
                if(Salvar(face, usuario) == true) {
                    jif.SalvarFace(face);
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(face, usuario) == true){
                    jif.SalvarFace(face);
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                }        
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }

    }
    
    public void ExcluirFace(Face face, Usuario usuario){
        if(face != null && usuario != null){
            List<Camada> lista = new CamadaDAO().ConsultarPorFace(face);
            for (Camada camada : lista) {
                new CamadaDAO().ExcluirCamada(camada, usuario);
            }
            Excluir(face, usuario);
        } 
    }
          
    public List<Face> ConsultarPorAmbiente(Ambiente ambiente) {
    List<Face> resultado = null;
    
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Face face where face.ambiente.id = " + ambiente.getId());
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }    
    
    public List<Face> ConsultarPorAmbiente(int id) {
    List<Face> resultado = null;
    
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            org.hibernate.Query q = sessao.createQuery("from Face face where face.ambiente.id = " + id);
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }  
      
       //Popular por um id
    public void popularTabela(JTable tabela, Ambiente ambiente) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Face> lista = ConsultarPorAmbiente(ambiente);

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Fluxo de Calor";
        cabecalho[3] = "Fluxo de Calor Vidro";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Faces: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Face face : lista) {
                
                dadosTabela[lin][0] = face.getId();
                dadosTabela[lin][1] = face.getDescricao();
                dadosTabela[lin][2] = face.getFluxoCalor();
                dadosTabela[lin][3] = face.getFluxoCalorVidro();
               

                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }

    }
    
    public Face ConsultarFace(int id) {
     Face face = new Face();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Face where id = " + id);
             face = Face.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return face;
     }    
}
