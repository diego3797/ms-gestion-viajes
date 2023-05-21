package com.prueba.msgestionviajes.util;

import com.prueba.msgestionviajes.dto.ViajeDTO;
import com.prueba.msgestionviajes.model.Viaje;
import org.springframework.beans.BeanUtils;

public class Utils {
    public static ViajeDTO entidadToDto(Viaje viaje){
        ViajeDTO viajeDTO = new ViajeDTO();
        BeanUtils.copyProperties(viaje, viajeDTO);
        return viajeDTO;
    }

    public static Viaje dtoToEntidad(ViajeDTO viajeDTO){
        Viaje viaje = new Viaje();
        BeanUtils.copyProperties(viajeDTO, viaje);
        return viaje;
    }
}
