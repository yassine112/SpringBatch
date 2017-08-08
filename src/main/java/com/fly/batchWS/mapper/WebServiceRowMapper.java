package com.fly.batchWS.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fly.batchWS.bean.WebService;

public class WebServiceRowMapper implements RowMapper<WebService> {

	@Override
	public WebService mapRow(ResultSet rs, int rowNum) throws SQLException {
		WebService webService = new WebService();
		
		webService.setIdWS(rs.getInt("ID_WS"));
		webService.setIdUrl(rs.getInt("ID_URL"));
		webService.setName(rs.getString("NAME"));
		webService.setDesc(rs.getString("DESCRIPTION"));
		webService.setMethode(rs.getString("METHODE"));
		webService.setDomaine(rs.getString("DOMAINE"));
		webService.setMsgEntree(rs.getString("MSG_ENTREE"));
		webService.setMsgRetour(rs.getString("MSG_RETOUR"));
		webService.setTypeUrl(rs.getString("TYPE_URL"));
		webService.setUrlDirect(rs.getString("URL_DIRECT"));
		webService.setUrlBroker(rs.getString("URL_BROKER"));
		webService.setIdServer(rs.getInt("ID_SERVER"));
		webService.setIdDataBase(rs.getInt("ID_BDD"));
		
		return webService;
	}

}
