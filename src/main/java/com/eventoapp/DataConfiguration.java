package com.eventoapp;

import javax.sql.DataSource;

/*
 * Interessante verificar é que cada vez que salvamos, automáticamente o servidor reinicia e atualiza
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//esta anotação diz para o spring que esta classe é de configuração do banco de Dados
@Configuration
public class DataConfiguration {
	
	
	
	 @Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eventoapp");
		dataSource.setUsername("root");
		dataSource.setPassword("suaSenha");
		/* para não ter erros, 
		 * o melhor é não colocar o return e
		 * sim deixar dar erro e colocar o que o java pedir qdo a letra for sublinhada
		 */
		return dataSource;
	}
	 
	
	
	
	
	@Bean	
	public JpaVendorAdapter JpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		//aqui é definido qual o banco de dados será utlilizado
		adapter.setDatabase(Database.MYSQL);
		/* com a opção true no setShowSql, 
		 * é mostrado as etapas de procedimentos no SQL, 
		 * como delete, update, insert e outros
		 *  no console da IDE
		 */
		adapter.setShowSql(true);
		/*
		 * Com a opção true do setGenerateDdl
		 * permite que o hibernate crie as tabelas 
		 * automáticamente
		 */
		adapter.setGenerateDdl(true);
		/*
		 * Aqui é informado o dialeto a ser utilizado pelo hibernate
		 * no caso é a plataforma de base de Dado do MySQL
		 * verificar se começa com org.hibernate.dialect, se não dará erro de conexão
		 * Por ter erros  'type=MyISAM' at line 1, foi necessário alterar de MySQLDialect para MySQL5Dialect
		 * dessa forma mudou de  “TYPE” para “ENGINE
		 */
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		/*
		 * Aqui é true para que o hibernate prepare a conexão com o banco de Dados
		 */
		adapter.setPrepareConnection(true);
		//é retornado um objeto adapter, pois o bean(que é annotation) retorna um metodo JpaVendorAdapter
		return adapter;
		
	}

}
