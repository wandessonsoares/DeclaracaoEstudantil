package br.edu.ifpb.pweb.audien.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class MySQLGenerateSchema {

	public static void main(String[] args) { 
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		System.out.println("Adicionando classes de entidade...");
		cfg.addAnnotatedClass(br.edu.ifpb.pweb.audien.model.Instituicao.class);
		cfg.addAnnotatedClass(br.edu.ifpb.pweb.audien.model.PeriodoLetivo.class);
		System.out.println("Definindo propriedades do Hibernate...");
		cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/audien?autoReconnect=true");
		cfg.setProperty("hibernate.connection.username", "root");
		cfg.setProperty("hibernate.connection.password", "");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		System.out.println("Exportando o esquema do banco...");
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.setOutputFile("src/mysql-schema.sql");
		schemaExport.setFormat(true);
		schemaExport.create(true, false);
		System.out.println("Arquivo do banco criado...");
	}

}
