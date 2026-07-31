package com.rpk.dsa.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TcpPacketOrder {
    private final Map<Integer, String> buffer = new HashMap<>();
    private int nextExpectedPacket;

    public TcpPacketOrder(int startPacketNum) {
        this.nextExpectedPacket = startPacketNum;
    }

    public List<Packet> receivePacket(int packetNum, String data) {
        List<Packet> emitted = new ArrayList<>();

        if (packetNum < nextExpectedPacket) {
            return emitted;
        }

        buffer.putIfAbsent(packetNum, data);

        while (buffer.containsKey(nextExpectedPacket)) {
            String currentData = buffer.remove(nextExpectedPacket);
            emitted.add(new Packet(nextExpectedPacket, currentData));
            nextExpectedPacket++;
        }

        return emitted;
    }

    public static final class Packet {
        private final int packetNum;
        private final String data;

        public Packet(int packetNum, String data) {
            this.packetNum = packetNum;
            this.data = data;
        }

        public int packetNum() {
            return packetNum;
        }

        public String data() {
            return data;
        }

        @Override
        public String toString() {
            return "Packet{packetNum=" + packetNum + ", data='" + data + "'}";
        }
    }

    public static void main(String[] args) {
        TcpPacketOrder packetOrder = new TcpPacketOrder(1);
        int[] receivedPackets = {1, 3, 4, 5, 2, 6};
        List<Integer> emittedOrder = new ArrayList<>();

        for (int packetNum : receivedPackets) {
            List<Packet> emitted = packetOrder.receivePacket(packetNum, "data-" + packetNum);
            emittedOrder.addAll(emitted.stream().map(Packet::packetNum).collect(Collectors.toList()));
            if (!emitted.isEmpty()) {
                System.out.println("Received " + packetNum + " -> emitted " + emitted);
            } else {
                System.out.println("Received " + packetNum + " -> emitted [] (waiting for missing packet)");
            }
        }

        System.out.println("Final emitted packet order: " + emittedOrder);
    }
}
