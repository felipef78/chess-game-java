/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author felip
 */
public enum ColorType {
    WHITE(0), BLACK(1);
    
    private final int value;
    
    ColorType(int value){
        this.value = value;
    }
}
