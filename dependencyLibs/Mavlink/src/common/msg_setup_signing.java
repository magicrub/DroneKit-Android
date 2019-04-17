/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SETUP_SIGNING PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
        
/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp will disable signing
 */
public class msg_setup_signing extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_SETUP_SIGNING = 256;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SETUP_SIGNING;


      
    /**
     * initial timestamp
     */
    public long initial_timestamp;
      
    /**
     * system id of the target
     */
    public short target_system;
      
    /**
     * component ID of the target
     */
    public short target_component;
      
    /**
     * signing key
     */
    public short secret_key[] = new short[32];
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_SETUP_SIGNING;
        
        packet.payload.putUnsignedLong(initial_timestamp);
        
        packet.payload.putUnsignedByte(target_system);
        
        packet.payload.putUnsignedByte(target_component);
        
        
        for (int i = 0; i < secret_key.length; i++) {
            packet.payload.putUnsignedByte(secret_key[i]);
        }
                    
        
        if(isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a setup_signing message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
        
        this.initial_timestamp = payload.getUnsignedLong();
        
        this.target_system = payload.getUnsignedByte();
        
        this.target_component = payload.getUnsignedByte();
        
         
        for (int i = 0; i < this.secret_key.length; i++) {
            if(!payload.hasRemaining()) break;
            this.secret_key[i] = payload.getUnsignedByte();
        }
                
        
        if(isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_setup_signing() {
        msgid = MAVLINK_MSG_ID_SETUP_SIGNING;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_setup_signing(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_SETUP_SIGNING;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);        
    }

            
    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_SETUP_SIGNING - sysid:"+sysid+" compid:"+compid+" initial_timestamp:"+initial_timestamp+" target_system:"+target_system+" target_component:"+target_component+" secret_key:"+secret_key+"";
    }
}
        