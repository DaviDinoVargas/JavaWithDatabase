package classes;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

	public class Jbdc {
	    private List<Produto> listaProdutos;
	    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	    public Jbdc() {
	        listaProdutos = new ArrayList<>();
	        carregarDadosDoBanco();
	    }

	    public void adicionarProduto(Produto produto) {
	        try (Connection con = conexao.getConexao();
	             PreparedStatement pst = con.prepareStatement("INSERT INTO produtos (descricao, preco, estoque, codigoProprio, dataHora) VALUES (?, ?, ?, ?, ?)")) {

	            Date dataHoraAtual = new Date();
	            String dataHoraFormatada = dateFormat.format(dataHoraAtual);

	            pst.setString(1, produto.getDescricao());
	            pst.setDouble(2, produto.getPreco());
	            pst.setInt(3, produto.getEstoque());
	            pst.setInt(4, produto.getCodigoProprio());
	            pst.setString(5, dataHoraFormatada);

	            pst.executeUpdate();
	            listaProdutos.add(produto);

	        } catch (SQLException e) {
	            System.out.println("Erro ao adicionar produto: " + e.getMessage());
	        }
	    }

	    public void carregarDadosDoBanco() {
	        try (Connection con = conexao.getConexao();
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")) {

	            while (rs.next()) {
	                String descricao = rs.getString("descricao");
	                double preco = rs.getDouble("preco");
	                int estoque = rs.getInt("estoque");
	                int codigoProprio = rs.getInt("codigoProprio");
	                String dataHora = rs.getString("dataHora");

	                Produto produto = new Produto(descricao, preco, estoque, codigoProprio);
	                produto.setDataHora(dataHora);
	                listaProdutos.add(produto);
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao carregar dados do banco: " + e.getMessage());}
	        }
	    public void removerProduto(int codigoProprio) {
	        for (Produto produto : listaProdutos) {
	            if (produto.getCodigoProprio() == codigoProprio) {
	                listaProdutos.remove(produto);
	                excluirProdutoDoBanco(codigoProprio);
	                return;
	            }
	        }
	        System.out.println("Produto não encontrado para o Código Próprio fornecido.");
	    }

	    private void excluirProdutoDoBanco(int codigoProprio) {
	        try (Connection con = conexao.getConexao();
	             PreparedStatement pst = con.prepareStatement("DELETE FROM produtos WHERE codigoProprio = ?")) {

	            pst.setInt(1, codigoProprio);
	            pst.executeUpdate();

	        } catch (SQLException e) {
	            System.out.println("Erro ao excluir produto do banco: " + e.getMessage());
	        }
	    }


	        void salvarDadosNoArquivo() {
				
				
			}

			public List<Produto> getListaProdutos() {
	            return listaProdutos;
	        }

	        public void listarTodosProdutos() {
	            for (Produto produto : listaProdutos) {
	                System.out.println(produto);
	            }
	        }

	        public void exibirProdutoPorCodigoProprio(int codigoProprio) {
	            for (Produto produto : listaProdutos) {
	                if (produto.getCodigoProprio() == codigoProprio) {
	                    System.out.println(produto);
	                    return;
	                }
	            }
	            System.out.println("Produto não encontrado para o Código Próprio fornecido.");
	        }
	        public void atualizarEstoqueNoBanco(Produto produto) {
	            try (Connection con = conexao.getConexao();
	                 PreparedStatement pst = con.prepareStatement("UPDATE produtos SET estoque = ? WHERE codigoProprio = ?")) {

	                pst.setInt(1, produto.getEstoque());
	                pst.setInt(2, produto.getCodigoProprio());
	                pst.executeUpdate();

	            } catch (SQLException e) {
	                System.out.println("Erro ao atualizar estoque no banco: " + e.getMessage());
	            }
	        }
	    }
	    

