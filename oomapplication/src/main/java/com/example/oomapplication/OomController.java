package com.example.oomapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OomController {

    // Static list to hold allocated memory and prevent garbage collection
    private static final List<byte[]> memoryHog = new ArrayList<>();

    @GetMapping("/trigger-oom")
    public String triggerOOM() {
        System.out.println("🔴 Attempting to allocate 1GB of memory...");

        try {
            for (int i = 0; i < 10; i++) { // Allocate 100MB * 10 = 1GB
                byte[] chunk = new byte[50 * 1024 * 1024]; // 50MB
                memoryHog.add(chunk);
                System.out.println("✅ Allocated: " + ((i + 1) * 100) + " MB");

                // Delay of 1 second between each allocation
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            System.err.println("⚠️ Allocation Interrupted!");
            Thread.currentThread().interrupt();
        }

        return "✅ Successfully allocated 1GB of memory!";
    }
}
