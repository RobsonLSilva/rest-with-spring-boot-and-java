package br.com.robson;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.robson.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	 @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	 public Double sum(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		 
		 if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		 
		 return convertToDouble(numberOne) + convertToDouble(numberTwo);
	 }
	 
	 @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	 public Double subtraction(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		 
		 if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			 throw new UnsupportedMathOperationException("Please set a numeric value");
		 }
		 
		 return convertToDouble(numberOne) - convertToDouble(numberTwo);
	 }
	 
	 @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	 public Double multiplication(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		 
		 if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			 throw new UnsupportedMathOperationException("Please set a numeric value");
		 }
		 
		 return convertToDouble(numberOne) * convertToDouble(numberTwo);
	 }
	 
	 @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	 public Double division(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		 
		 if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			 throw new UnsupportedMathOperationException("Please set a numeric value");
		 }
		 
		 return convertToDouble(numberOne) / convertToDouble(numberTwo);
	 }
	 
	 @RequestMapping(value = "/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	 public Double average(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		 
		 if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			 throw new UnsupportedMathOperationException("Please set a numeric value");
		 }		
		 return  (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	 }
	 
	 @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	 public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
		 
		 if (!isNumeric(number)) {
			 throw new UnsupportedMathOperationException("Please set a numeric value");
		 }
		 
		 return Math.sqrt(convertToDouble(number)) ;
	 }

	 private Double convertToDouble(String strNumber) {
		if (strNumber == null) 
			return 0D;
		
		// BR 10,25 US 10.25
		String number = strNumber.replaceAll(",", ".");
		
		if (isNumeric(number)) 
			return Double.parseDouble(number);	
		
		return 0D;
	}

	 private boolean isNumeric(String strNumber) {
		if (strNumber == null) 
			return false;
		
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
