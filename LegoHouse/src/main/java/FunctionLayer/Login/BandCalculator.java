/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Login;

/**
 *
 * @author Esben
 */
public class BandCalculator {

    public int bandType(String bandName) {
        if (bandName.equals("½-stensforbandt")) {
            return 1;
        }
        if (bandName.equals("1/4-stensforbandt")) {
            return 2;
        }
        if (bandName.equals("Blok forbandt")) {
            return 3;
        }
        if (bandName.equals("Kryds forbandt")) {
            return 4;
        }
        if (bandName.equals("Engelsk forbandt")) {
            return 5;
        }
        return 0;
    }

    public int[] halfBand(int width, int length, int height) {
        int x4 = length / 4;
        int x2 = 0;
        int x1 = 0;
        switch (length % 4) {
            case 0:
                break;
            case 1:
                x1++;
                break;
            case 2:
                width += 2;
                break;
            case 3:
                width += 2;
                x1++;
        }
        if (length >= 4) {
            width = width - 4;
        }
        x4 = width / 4 + x4;
        switch (width % 4) {
            case 0:
                break;
            case 1:
                x1++;
                break;
            case 2:
                x2++;
                break;
            case 3:
                x2++;
                x1++;
        }
        x4 = x4 * height * 2;
        x2 = x2 * height * 2;
        x1 = x1 * height * 2;
        int[] ret = {x4, x2, x1};
        return ret;
    }

    public int[] makeBands(int width, int length, int height, int bandNumber) {
        switch (bandNumber) {
            case 1:
                return halfBand(width, length, height);
            case 2:
                
            case 3:
                
            case 4:
                
            case 5:
                
        }
        int[] fail = {0,0,0};
        return  fail;
    }
}
