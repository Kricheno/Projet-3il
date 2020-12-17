package com.example.projet.service;

import com.example.projet.api.wmi.OSDetector;
import com.example.projet.api.wmi.PowerShell;
import com.example.projet.api.wmi.PowerShellResponse;
import com.example.projet.entity.Poste;

import com.example.projet.entity.Poste;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *	@desc	Static WOL magic packet class
 */
@Service
public class WakeOnLanService
{

    public static final String BROADCAST = "172.16.255.255";

    public void wakeOnLanByShell(Poste poste){
        if (OSDetector.isWindows()) {
            PowerShell powerShell = PowerShell.openSession();
            PowerShellResponse response = powerShell.executeCommand("C:\\Windows\\System32\\wol.exe "+poste.getAdresse_Mac()+" /d "+BROADCAST);
            powerShell.close();
        }
    }




}
