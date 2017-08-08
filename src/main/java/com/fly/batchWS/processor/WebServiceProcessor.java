package com.fly.batchWS.processor;

import org.springframework.batch.item.ItemProcessor;

import com.fly.batchWS.bean.WebService;
import com.fly.batchWS.opperation.CallWebService;

public class WebServiceProcessor implements ItemProcessor<WebService, WebService> {

	@Override
	public WebService process(WebService item) throws Exception {
		// TODO Auto-generated method stub
		WebService webService = item;
		
		CallWebService.getInstance().call(webService);
		
		return null;
	}

}
