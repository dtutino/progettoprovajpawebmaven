package it.prova.progettoprovajpawebmaven.utility;

import org.apache.commons.lang3.StringUtils;

public class Utility {
	
	public static boolean validateCommonEntity(String descrizioneInputParam) {
		if (StringUtils.isBlank(descrizioneInputParam)) {
			return false;
		}
		return true;
	}
	
	public static boolean validateSegnalazione(String tipoSegnalazioneInputParam, String descrizioneInputParam, String localitaInputParam) {
		if(StringUtils.isBlank(tipoSegnalazioneInputParam) || StringUtils.isBlank(descrizioneInputParam) || StringUtils.isBlank(localitaInputParam)) {
			return false;
		}
		return true;
	}
	
	public static Long parseIdArrivoFromString(String idArrivoStringParam) {
		if (StringUtils.isBlank(idArrivoStringParam))
			return null;

		try {
			return Long.parseLong(idArrivoStringParam);
		} catch (Exception e) {
			return null;
		}
	}
 
}
