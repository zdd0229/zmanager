package com.z.security.jwt;

import org.springframework.core.io.ClassPathResource;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Objects;

public class KeyPairFactory {

    private KeyStore store;

    private final Object lock = new Object();

    KeyPair create(String keyPath,String keyAlias,String KeyPass){
        ClassPathResource classPathResource = new ClassPathResource(keyPath);
        char pem[] = KeyPass.toCharArray();
        try{
            synchronized (lock){
                if(Objects.isNull(store)){
                    synchronized (lock){
                        store = KeyStore.getInstance("jks");
                        store.load(classPathResource.getInputStream(),pem);
                    }
                }
            }
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) store.getKey(keyAlias, pem);
            RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
            return new KeyPair(publicKey, key);
        }catch (Exception e) {
            throw new IllegalStateException("Cannot load keys from store: " + classPathResource, e);
        }
    }

}
