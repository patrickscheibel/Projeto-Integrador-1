/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.CorMaterial;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframeCorMaterial;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author patrick.scheibel
 */
public class CorMaterialDAO extends DAO{
      
    public void SalvarCorMaterial(CorMaterial corMaterial, JIframeCorMaterial jIframeCorMaterial, Usuario usuario){
        JIframeCorMaterial jif = jIframeCorMaterial;
        if(!corMaterial.getDescricao().isEmpty()){
            if(corMaterial.getId() == null){
                if(Salvar(corMaterial, usuario) == true) {
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(corMaterial, usuario) == true){
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
        } else {
            new DlgAviso("Dados Incorretos ou invalidos");
        }
    }
    
    public void ExcluirCorMaterial(Integer corMaterialId, Usuario usuario){
       if(usuario != null){
            CorMaterial corCorMaterial = new CorMaterialDAO().ConsultarCorMaterial(corMaterialId);         
            Excluir(corCorMaterial, usuario);
        }
    }
          
    public List<CorMaterial> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from CorMaterial");
                resultado = q.list();

            } catch (HibernateException he) {
                he.printStackTrace();
            }
            return resultado;
        }           
      
   
    
       //Popular por um id
    public void popularTabela(JTable tabela) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<CorMaterial> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Radiacao Minima";
        cabecalho[3] = "Radiacao Maxima";

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os CorMaterial: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (CorMaterial corMaterial : lista) {
                
                dadosTabela[lin][0] = corMaterial.getId();
                dadosTabela[lin][1] = corMaterial.getDescricao();
                dadosTabela[lin][2] = corMaterial.getRadiacaoMinima();
                dadosTabela[lin][3] = corMaterial.getRadiacaoMaxima();
                

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
    
    public CorMaterial ConsultarCorMaterial(int id) {
    CorMaterial corMaterial = new CorMaterial();

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from CorMaterial where id = " + id);
            corMaterial = CorMaterial.class.cast(q.uniqueResult());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return corMaterial;
    }   
    
}
