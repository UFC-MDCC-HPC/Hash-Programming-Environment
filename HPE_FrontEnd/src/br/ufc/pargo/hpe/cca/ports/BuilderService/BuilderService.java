/**
 * BuilderService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public interface BuilderService extends javax.xml.rpc.Service {
    public java.lang.String getBuilderServiceSoap12Address();

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap12() throws javax.xml.rpc.ServiceException;

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getBuilderServiceSoapAddress();

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap() throws javax.xml.rpc.ServiceException;

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
