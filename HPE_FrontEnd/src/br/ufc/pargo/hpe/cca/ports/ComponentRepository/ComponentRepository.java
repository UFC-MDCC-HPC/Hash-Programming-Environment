/**
 * ComponentRepository.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.ComponentRepository;

public interface ComponentRepository extends javax.xml.rpc.Service {
    public java.lang.String getComponentRepositorySoapAddress();

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap() throws javax.xml.rpc.ServiceException;

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getComponentRepositorySoap12Address();

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap12() throws javax.xml.rpc.ServiceException;

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
