/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE PLAY_TUNE PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * Control vehicle tone generation (buzzer)
 */
public class msg_play_tune extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_PLAY_TUNE = 258;
    public static final int MAVLINK_MSG_LENGTH = 232;
    private static final long serialVersionUID = MAVLINK_MSG_ID_PLAY_TUNE;


      
    /**
     * System ID
     */
    public short target_system;
      
    /**
     * Component ID
     */
    public short target_component;
      
    /**
     * tune in board specific format
     */
    public byte tune[] = new byte[30];
      
    /**
     * tune extension (appended to tune)
     */
    public byte tune2[] = new byte[200];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_PLAY_TUNE;
        
        packet.payload.putUnsignedByte(target_system);
        
        packet.payload.putUnsignedByte(target_component);
        
        
        for (int i = 0; i < tune.length; i++) {
            packet.payload.putByte(tune[i]);
        }
                    
        
        if(isMavlink2) {
            
            
        for (int i = 0; i < tune2.length; i++) {
            packet.payload.putByte(tune2[i]);
        }
                    
            
        }
        return packet;
    }

    /**
     * Decode a play_tune message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.target_system = payload.getUnsignedByte();
        
        this.target_component = payload.getUnsignedByte();
        
         
        for (int i = 0; i < this.tune.length; i++) {
            if(!payload.hasRemaining()) break;
            this.tune[i] = payload.getByte();
        }
                
        
        if(isMavlink2) {
            
             
        for (int i = 0; i < this.tune2.length; i++) {
            if(!payload.hasRemaining()) break;
            this.tune2[i] = payload.getByte();
        }
                
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_play_tune() {
        msgid = MAVLINK_MSG_ID_PLAY_TUNE;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_play_tune(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_PLAY_TUNE;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

         
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setTune(String str) {
        int len = Math.min(str.length(), 30);
        for (int i=0; i<len; i++) {
            tune[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<30; i++) {            // padding for the rest of the buffer
            tune[i] = 0;
        }
    }

    /**
    * Gets the message, formated as a string
    */
    public String getTune() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 30; i++) {
            if (tune[i] != 0)
                buf.append((char) tune[i]);
            else
                break;
        }
        return buf.toString();

    }
                          
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setTune2(String str) {
        int len = Math.min(str.length(), 200);
        for (int i=0; i<len; i++) {
            tune2[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<200; i++) {            // padding for the rest of the buffer
            tune2[i] = 0;
        }
    }

    /**
    * Gets the message, formated as a string
    */
    public String getTune2() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 200; i++) {
            if (tune2[i] != 0)
                buf.append((char) tune2[i]);
            else
                break;
        }
        return buf.toString();

    }
                         
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_PLAY_TUNE - sysid:"+sysid+" compid:"+compid+" target_system:"+target_system+" target_component:"+target_component+" tune:"+tune+" tune2:"+tune2+"";
    }
}
        