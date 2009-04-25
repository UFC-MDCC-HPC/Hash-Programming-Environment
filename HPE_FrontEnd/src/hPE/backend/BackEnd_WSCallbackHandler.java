
/**
 * BackEnd_WSCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package hPE.backend;

    /**
     *  BackEnd_WSCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BackEnd_WSCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BackEnd_WSCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BackEnd_WSCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for readEnvironment method
            * override this method for handling normal response from readEnvironment operation
            */
           public void receiveResultreadEnvironment(
                    hPE.backend.BackEnd_WSStub.ReadEnvironmentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from readEnvironment operation
           */
            public void receiveErrorreadEnvironment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for hosts method
            * override this method for handling normal response from hosts operation
            */
           public void receiveResulthosts(
                    hPE.backend.BackEnd_WSStub.HostsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hosts operation
           */
            public void receiveErrorhosts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for runApplication method
            * override this method for handling normal response from runApplication operation
            */
           public void receiveResultrunApplication(
                    hPE.backend.BackEnd_WSStub.RunApplicationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from runApplication operation
           */
            public void receiveErrorrunApplication(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deployHashComponent method
            * override this method for handling normal response from deployHashComponent operation
            */
           public void receiveResultdeployHashComponent(
                    hPE.backend.BackEnd_WSStub.DeployHashComponentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deployHashComponent operation
           */
            public void receiveErrordeployHashComponent(java.lang.Exception e) {
            }
                


    }
    