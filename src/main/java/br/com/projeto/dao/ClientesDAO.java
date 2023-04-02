/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;
import br.com.projeto.model.Clientes;
import br.com.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author igora
 */
public class ClientesDAO {
    private Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    //Metodo cadastrarCliente
    public void cadastrarCliente(Clientes obj){
        try {
            String sql = 
                "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,complemento,bairro,cidade,estado) "
                + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome() );
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setString(9,obj.getComplemento());
            stmt.setString(10,obj.getBairro());
            stmt.setString(11,obj.getCidade());
            stmt.setString(12,obj.getEstado());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!" + e);
        }
    }
    
    //Metodo alterarCliente
    public void alterarCliente(){
        
    }
    //MNetodo excluirCliente
    public void excluirCliente(){
        
    }
    //Metodo Listar Todos os Clientes
    public List<Clientes>listarClientes(){
        try {
            // Criar lista
            List<Clientes> lista = new ArrayList<>();
            
            // Criar o SQL, organizar e executar
            String sql = "SELECT * FROM tb_clientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery(); // SEMPRE QUANDO FOR USAR SELEC TEM QUE USAR OBJ RESULTSET
            
            while(rs.next()){
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
}
