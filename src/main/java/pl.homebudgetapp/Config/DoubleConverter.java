package pl.homebudgetapp.Config;

import org.springframework.core.convert.converter.Converter;

public class DoubleConverter implements Converter<String, Double> {

	@Override
	public Double convert(String s) {

		return Double.parseDouble(s);
	}

}
