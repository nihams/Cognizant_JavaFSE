package com.cognizant.springlearn.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.model.CountryList;

@Service
public class CountryService {
	public Country getCountry(String code) {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		CountryList countryList=context.getBean("countryList",CountryList.class);
		List<Country> countries=countryList.getCountryList();
		for(Country country:countries) {
			if(country.getCode().equalsIgnoreCase(code)) {
				return country;
			}
		}
		return null;
	}
}
