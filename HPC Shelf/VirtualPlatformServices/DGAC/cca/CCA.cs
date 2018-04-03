
/** The generic domain gov, which CCA claims to be a direct descendant of
since more than just Department of Energy folks defined the specification. */
using System;
using System.Runtime.Serialization;
using System.ServiceModel;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.ports;
using gov.cca.ports;


namespace gov
{
    /** Common Component Architecture. Component approaches for Scientific Computing. */
    namespace cca
    { /** version 0.8.5 */

        /** All ports must derive from this port type */
        //(gkk) unchanged from 0.5
		[ServiceContract]
		[ServiceKnownType(typeof(GoPort))]
		[ServiceKnownType(typeof(GoPortWrapper))]
		[ServiceKnownType(typeof(InitializePort))]
		[ServiceKnownType(typeof(InitializePortWrapper))]
		[ServiceKnownType(typeof(ReconfigurationAdvicePort))]
		[ServiceKnownType(typeof(ReconfigurationAdvicePortWrapper))]
        public interface Port { }

        /** 
         * Mapping of standard exceptional event types
         * occuring in the Services interface to integers. 
         */
        public enum CCAExceptionType
        {

            /* Someone caught a non-CCAException that was declared
             *  at an interface that claims it throws ONLY CCAException. 
             */
            Unexpected = -1,

            /* A CCAException that is carrying a non-standard message. */
            Nonstandard = 1,

            /* Action attempted on a port name that is neither registered
             * nor added. 
             */
            PortNotDefined = 2,

            /* Adding/registering an already added/registered Port was
             *  attempted. 
             */
            PortAlreadyDefined = 3,

            /* Attempt to getPort, getPortNonblocking, or releasePort
             * with a port named that is not connected. 
             */
            PortNotConnected = 4,

            /* Redundant attempt to release a Port. */
            PortNotInUse = 5,

            /* Attempt to unregister a Port that is still being used. */
            UsesPortNotReleased = 6,

            /* Port name given to createPortInfo is bogus. */
            BadPortName = 7,

            /* Port class/type given to createPortInfo is bogus. */
            BadPortType = 8,

            /* 
             * Port properties given to createPortInfo is bogus.
             * Note: null is NOT a bogus input, but a fairly common one. 
             */
            BadProperties = 9,

            /* PortInfo given in port add/register call is bogus or null. */
            BadPortInfo = 10,

            /* Services implementation failed to allocate memory. */
            OutOfMemory = 11,

            /* Port (or function within it) died on a remote error. */
            NetworkError = 12,

        } // end enum CCAExceptionType



        /** Most CCA interfaces throw this exception. */
        public interface CCAException
        {// : sidl.BaseException { 
            CCAExceptionType getCCAExceptionType();
        } // end interface CCAException


        /** The one interface all frameworks must implement. A unique instance
         * of this is given to each component. */		

		[ServiceContract]
		[ServiceKnownType(typeof(InitializePortWrapper))]
		[ServiceKnownType(typeof(TypeMapImpl))]
		public interface Services
        {

            /** 
             * Fetch a previously registered Port (defined by either 
             * addProvidePort or (more typically) registerUsesPort).  
             * @return Will return the Port (possibly waiting forever while
             * attempting to acquire it) or throw an exception. Does not return
             * NULL, even in the case where no connection has been made. 
             * If a Port is returned,
             * there is then a contract that the port will remain valid for use
             * by the caller until the port is released via releasePort(), or a 
             * Disconnect Event is successfully dispatched to the caller,
             * or a runtime exception (such as network failure) occurs during 
             * invocation of some function in the Port. 
             * <p>
             * Subtle interpretation: If the Component is not listening for
             * Disconnect events, then the framework has no clean way to
             * break the connection until after the component calls releasePort.
             * </p>
             * <p>The framework may go through some machinations to obtain
             *    the port, possibly involving an interactive user or network 
             *    queries, before giving up and throwing an exception.
             * </p>
             * 
             * @param portName The previously registered or provide port which
             * 	   the component now wants to use.
             * @exception CCAException with the following types: NotConnected, PortNotDefined, 
             *                NetworkError, OutOfMemory.
             */
			[OperationContract]
			Port getPort(string portName);// throws CCAException;



            /** 
             * Get a previously registered Port (defined by
             * either addProvide or registerUses) and return that
             * Port if it is available immediately (already connected
             * without further connection machinations).
             * There is an contract that the
             * port will remain valid per the description of getPort.
             * @return The named port, if it exists and is connected or self-provided,
             * 	      or NULL if it is registered and is not yet connected. Does not
             * 	      return if the Port is neither registered nor provided, but rather
             * 	      throws an exception.
             * @param portName registered or provided port that
             * 	     the component now wants to use.
             * @exception CCAException with the following types: PortNotDefined, OutOfMemory.
             */
			[OperationContract]
			//[ServiceKnownType(typeof(GoPort))]
			//[ServiceKnownType(typeof(GoPortWrapper))]
			[ServiceKnownType(typeof(InitializePort))]
			[ServiceKnownType(typeof(InitializePortWrapper))]
			//[ServiceKnownType(typeof(ReconfigurationAdvicePort))]
			//[ServiceKnownType(typeof(ReconfigurationAdvicePortWrapper))]
			Port getPortNonblocking(string portName);// throws CCAException;

            /** 
             * Notifies the framework that this component is finished 
             * using the previously fetched Port that is named.     
             * The releasePort() method calls should be paired with 
             * getPort() method calls; however, an extra call to releasePort()
             * for the same name may (is not required to) generate an exception.
             * Calls to release ports which are not defined or have never be fetched
             * with one of the getPort functions generate exceptions.
             * @param portName The name of a port.
             * @exception CCAException with the following types: PortNotDefined, PortNotInUse.
             */
			[OperationContract]
			void releasePort(string portName);// throws CCAException;


            /**
             * Creates a TypeMap, potentially to be used in subsequent
             * calls to describe a Port.  Initially, this map is empty.
             */
            TypeMap createTypeMap();// throws CCAException;

            /** 
             * Register a request for a Port that will be retrieved subsequently 
             * with a call to getPort().
             * @param portName A string uniquely describing this port.  This string
             * must be unique for this component, over both uses and provides ports.
             * @param type A string desribing the type of this port.
             * @param properties A TypeMap describing optional properties
             * associated with this port. This can be a null pointer, which
             * indicates an empty list of properties.  Properties may be
             * obtained from createTypeMap or any other source.  The properties
             * be copied into the framework, and subsequent changes to the
             * properties object will have no effect on the properties
             * associated with this port.
             * In these properties, all frameworks recognize at least the
             * following keys and values in implementing registerUsesPort:
             * <pre>
             * key:              standard values (string form)     default
             * "MAX_CONNECTIONS" any nonnegative integer, "unlimited".   1
             * "MIN_CONNECTIONS" any integer > 0.                        0
             * "ABLE_TO_PROXY"   "true", "false"                      "false"
             * </pre>
             * The component is not expected to work if the framework
             * has not satisfied the connection requirements.
             * The framework is allowed to return an error if it
             * is incapable of meeting the connection requirements,
             * e.g. it does not implement multiple uses ports.
             * The caller of registerUsesPort is not obligated to define
             * these properties. If left undefined, the default listed above is
             *       assumed.
             * @exception CCAException with the following types: PortAlreadyDefined, OutOfMemory.
             */
			[OperationContract]
			void registerUsesPort(string portName,
                          string type,
                          TypeMap properties);// throws CCAException ;

            /** 
             * Notify the framework that a Port, previously registered by this
             * component but currently not in use, is no longer desired. 
             * Unregistering a port that is currently 
             * in use (i.e. an unreleased getPort() being outstanding) 
             * is an error.
             * @param portName The name of a registered Port.
             * @exception CCAException with the following types: UsesPortNotReleased, PortNotDefined.
             */
			[OperationContract]
            void unregisterUsesPort(string portName);// throws CCAException ;


            /** 
             * Exposes a Port from this component to the framework.  
             * This Port is now available for the framework to connect 
             * to other components. 
             * @param inPort An abstract interface (tagged with CCA-ness
             * 	by inheriting from gov.cca.Port) the framework will
             * 	make available to other components.
             * 
             * @param portName string uniquely describing this port.  This string
             * must be unique for this component, over both uses and provides ports.
             * 
             * @param type string describing the type (class) of this port.
             * 
             * @param properties A TypeMap describing optional properties
             * associated with this port. This can be a null pointer, which
             * indicates an empty list of properties.  Properties may be
             * obtained from createTypeMap or any other source.  The properties
             * be copied into the framework, and subsequent changes to the
             * properties object will have no effect on the properties
             * associated with this port.
             * In these properties, all frameworks recognize at least the
             * following keys and values in implementing registerUsesPort:
             * <pre>
             * key:              standard values (string form)     default
             * "MAX_CONNECTIONS" any nonnegative integer, "unlimited".   1
             * "MIN_CONNECTIONS" any integer > 0.                        0
             * "ABLE_TO_PROXY"   "true", "false"                      "false"
             * </pre>
             * The component is not expected to work if the framework
             * has not satisfied the connection requirements.
             * The framework is allowed to return an error if it
             * is incapable of meeting the connection requirements,
             * e.g. it does not implement multiple uses ports.
             * The caller of addProvidesPort is not obligated to define
             * these properties. If left undefined, the default listed above is
             * assumed.
             * @exception CCAException with the following types: PortAlreadyDefined, OutOfMemory.
             */
			[OperationContract]
            void addProvidesPort(Port inPort,
                         string portName,
                     	 string type,
                         TypeMap properties);// throws CCAException ;


            /** Returns the complete list of the properties for a Port.  This
               includes the properties defined when the port was registered
               (these properties can be modified by the framework), two special
               properties "cca.portName" and "cca.portType", and any other
               properties that the framework wishes to disclose to the component.
               The framework may also choose to provide only the subset of input
               properties (i.e. from addProvidesPort/registerUsesPort) that it
               will honor.
               */
			[OperationContract]
            TypeMap getPortProperties(string name);

            /** Notifies the framework that a previously exposed Port is no longer 
             * available for use. The Port being removed must exist
             * until this call returns, or a CCAException may occur.
             * @param portName The name of a provided Port.
             * @exception PortNotDefined. In general, the framework will not dictate 
             * when the component chooses to stop offering services.
             */
			[OperationContract]
            void removeProvidesPort(string portName);// throws CCAException ;

            /** 
             * Get a reference to the component to which this 
             * Services object belongs. 
             */
			[OperationContract]
			ComponentID getComponentID();


            /** Obtain a callback for component destruction.
         * @param callBack an object that implements the ComponentRelease
         * interface that will be called when the component is to be destroyed.
         *
         * Register a callback to be executed when the component is going
         * to be destroyed.  During this callback, the Services object passed
         * through setServices will still be valid, but after all such
         * callbacks are made for a specific component, subsequent usage
         * of the Services object is not allowed/is undefined.
         */
			[OperationContract]
            void registerForRelease(ComponentRelease callBack);// throws CCAException;
        }


        /**
         * All components must implement this interface.
         */
        public interface Component
        {
            /** Starts up a component presence in the calling framework.
             * @param services the component instance's handle on the framework world.
             * Contracts concerning services and setServices:
             *
             * The component interaction with the CCA framework
             * and Ports begins on the call to setServices by the framework.
             *
             * This function is called exactly once for each instance created
             * by the framework.
             *
             * The argument services will never be nil/null.
             *
             * Those uses ports which are automatically connected by the framework
             * (so-called service-ports) may be obtained via getPort during
             * setServices.
             */
            void setServices(Services services);// throws CCAException;
        }

        /** An interface so the framework can inform the component when
            the component is about to be destroyed. Components managing
        memory, files, or other global resources should usually implement
        this interface and register it via Services.registerForRelease.
         */
        public interface ComponentRelease
        {
            /**
             * Shuts down a component presence in the calling framework.
             * @param services the component instance's handle on the framework world.
             * Contracts concerning services and setServices:
             *
             * This function is called exactly once for each callback registered
             * through Services.
             *
             * The argument services will never be nil/null.
             * The argument services will always be the same as that received in
             * setServices.
             *
             * During this call the component should release any interfaces
             * acquired by getPort().
             *
             * During this call the component should reset to nil any stored
             * reference to services.
             *
             * After this call, the component instance will be removed from the
             * framework. If the component instance was created by the
             * framework, it will be destroyed, not recycled, The behavior of
             * any port references obtained from this component instance and
             * stored elsewhere becomes undefined.
             *
             * Notes for the component implementor:
             * 1) The component writer may perform blocking activities
             * within releaseServices, such as waiting for remote computations
             * to shutdown.
             * 2) It is good practice during releaseServices for the component
             * writer to remove or unregister all the ports it defined.
             */
            void releaseServices(Services services);// throws CCAException;
        }

         /**
         * An opaque reference to a Component.
         */

        [DataContract]
		[KnownType(typeof(WorkerComponentIDImpl))]
        public abstract class ComponentID
        {
            /** 
             * Returns the instance name provided in 
             * <code>BuilderService.createInstance()</code>
             * or in 
             * <code>AbstractFramework.getServices()</code>.
             * @throws CCAException if <code>ComponentID</code> is invalid
             */
            public abstract string getInstanceName();// throws CCAException ;

            /**
             * Returns a framework specific serialization of the ComponentID.
             * @throws CCAException if <code>ComponentID</code> is
             * invalid.
             */
            public abstract string getSerialization();// throws CCAException ;
        }

        /** The primitive data types (and arrays of same) supported by CCA
        TypeMaps and Babel. */
		public enum Type
        {
            NoType, Int, Long, Float, Double, Fcomplex, Dcomplex, String, Bool,
            IntArray, LongArray, FloatArray, DoubleArray, FcomplexArray,
            DcomplexArray, StringArray, BoolArray
        }


        /** Detailed exception describing a type mismatch in getting
        or setting a value in a TypeMap. */
        interface TypeMismatchException : CCAException
        {
            /** @return the enumerated value Type sought */
            Type getRequestedType();
            /** @return the enumerated value Type sought */
            Type getActualType();
        }

        /** 
         *  A CCA map.  Maps a string key to a particular value. Types are
         *  strictly enforced.  For example, values places into the map
         *  using putInt can be retrieved only using getInt.  Calls to
         *  getLong, getString, getIntArray and other get methods will
         *  fail (i.e. return the default value). 
         */
		[DataContract]
		[KnownType(typeof(TypeMapImpl))]
		[KnownType(typeof(string[]))]
		[KnownType(typeof(int[]))]
		public abstract class TypeMap
        {
            /** Create an exact copy of this Map */
            public abstract TypeMap cloneTypeMap();

            /** Create a new Map with no key/value associations. */
            public abstract TypeMap cloneEmpty();

            /*
             * Get the scalar value associated with a given key.  If the key
             * was not found, return the default value. 
             */
            public abstract int getInt(string key, int dflt);// throws TypeMismatchException;
            public abstract long getLong(string key, long dflt);// throws TypeMismatchException;
            public abstract float getFloat(string key, float dflt);// throws TypeMismatchException;
            public abstract double getDouble(string key, double dflt);// throws TypeMismatchException;
            //fcomplex getFcomplex(string key, fcomplex dflt);// throws TypeMismatchException;
            //dcomplex getDcomplex(string key, dcomplex dflt);// throws TypeMismatchException;
            public abstract string getString(string key, string dflt);// throws TypeMismatchException;
            public abstract bool getBool(string key, bool dflt);// throws TypeMismatchException;

            /*
             * Get an array value associated with a given key.  If the key
             * was not found, return the dflt value. 
             */
            public abstract int[] getIntArray(string key, int[] dflt);
            //throws TypeMismatchException;
            public abstract long[] getLongArray(string key, long[] dflt);
            //throws TypeMismatchException;
            public abstract float[] getFloatArray(string key, float[] dflt);
            //throws TypeMismatchException;
            public abstract double[] getDoubleArray(string key, double[] dflt);
            //throws TypeMismatchException;
            //fcomplex[] getFcomplexArray(string key, fcomplex[] dflt); 
            //throws TypeMismatchException;
            //dcomplex[] getDcomplexArray(string key, dcomplex[] dflt); 
            //throws TypeMismatchException;
            public abstract string[] getStringArray(string key, string[] dflt);
            //throws TypeMismatchException; 
            public abstract bool[] getBoolArray(string key, bool[] dflt);
            //throws TypeMismatchException;

            /** 
             * Assign a key and value. Any value previously assigned
             * to the same key will be overwritten so long as it
             * is of the same type. If types conflict, an exception occurs.
             */
            public abstract void putInt(string key, int value);// throws TypeMismatchException;
            public abstract void putLong(string key, long value);// throws TypeMismatchException;
            public abstract void putFloat(string key, float value);// throws TypeMismatchException;
            public abstract void putDouble(string key, double value);// throws TypeMismatchException;
            //void putFcomplex(string key, fcomplex value);// throws TypeMismatchException;
            //void putDcomplex(string key, dcomplex value);// throws TypeMismatchException;
            public abstract void putString(string key, string value);// throws TypeMismatchException;
            public abstract void putBool(string key, bool value);// throws TypeMismatchException;

            public abstract void putIntArray(string key, int[] value);// throws TypeMismatchException;
            public abstract void putLongArray(string key, long[] value);// throws TypeMismatchException;
            public abstract void putFloatArray(string key, float[] value);// throws TypeMismatchException;
            public abstract void putDoubleArray(string key, double[] value);// throws TypeMismatchException;
            //void putFcomplexArray(string key, fcomplex[] value);// throws TypeMismatchException;
            //void putDcomplexArray(string key, dcomplex[] value);// throws TypeMismatchException;
            public abstract void putStringArray(string key, string[] value);// throws TypeMismatchException;
            public abstract void putBoolArray(string key, bool[] value);// throws TypeMismatchException;

            /** Make the key and associated value disappear from the object. */
            public abstract void remove(string key);

            /** 
             *  Get all the names associated with a particular type
             *  without exposing the data implementation details.  The keys
             *  will be returned in an arbitrary order. If type specified is
             *  NoType (no specification) all keys of all types are returned.
             */
            public abstract string[] getAllKeys(Type t);

            /** Return true if the key exists in this map */
            public abstract bool hasKey(string key);

            /** Return the type of the value associated with this key */
            public abstract Type typeOf(string key);

        }  // end interface TypeMap



        /** 
         *  This is an interface presented by a CCA-compliant framework to access its 
         *  application framing capabilities. Most of the manipulation of the 
         *  underlying framework is expected to be be done with the 
         *  gov.cca.BuilderService Port. This class exists as a sort of bootstrap 
         *  to get a Services object necessary to retrieve Port's, including 
         *  BuilderService, from the underlying framework. How the interface and 
         *  the underlying framework is created is entirely unspecified and is up 
         *  to the devices of the programmer and the framework provider.
         *
         *  <p>Example</p>
         *  <p>
         *  Here it is assumed that an instance of AbstractFramework
         *  is created in the main() from some hypothetical implementation.
         *  The idea is to allow a complete swap of framework choice by 
         *  changing out the specified implementation class of a framework.
         *  </p>
         *
         *  <code><pre>
         *  // java
         *  main() {
         *    cca.reference.Framework fwkimpl = new cca.reference.Framework();
         *    // change fwkimpl above to use different cca implementations when
         *    // AbstractFramework becomes part of the standard.
         *    gov.cca.AbstractFramework fwk = (gov.cca.AbstractFramework)fwkimpl;
         *    gov.cca.Services svc = 
         *	   fwk.getServices("instance0","AppDriver",null);
         *    // From here on, access all services, components, etc
         *    // through svc.
         *    ...
         *    // when done
         *    fwk.releaseServices(svc);
         *    fwk.shutdownFramework();
         *  }
         *
         *  // c++
         *  int functionName() {
         *    ::gov::sandia::ccafe::Framework fwkimpl;
         *    ::gov::cca::AbstractFrameworkPtr fwk;
         *
         *    fwk = fwkimpl.getStandardFramework();
         *    ::gov::cca::Services_Interface * svc = 0;
         *    svc = fwk->getServices("instance0","AppDriver",0);
         *    // From here on, access all services, components, etc
         *    // through svc.
         *    ...
         *    // when done
         *    fwk->releaseServices(svc);
         *    svc = 0;
         *    fwk->shutdownFramework();
         *
         *    // at scope exit, all memory is automatically cleaned up.
         *  }
         *  </pre></code>
         */
		[ServiceContract]
		[ServiceKnownType(typeof(TypeMapImpl))]
		//[ServiceKnownType(typeof(WorkerServicesImpl2))]
		public interface AbstractFramework
        {
            /** 
             *  Create an empty TypeMap. Presumably this would be used in 
             *  an ensuing call to <code>getServices()</code>. The "normal" method of
             *  creating typemaps is found in the <code>Services</code> interface. It
             *  is duplicated here to break the "chicken and egg" problem.
             */

            TypeMap createTypeMap();// throws CCAException;


            /** 
             * Retrieve a Services handle to the underlying framework. 
             * This interface effectively causes the calling program to 
             * appear as the image of a component inside the framework.
             * This method may be called any number of times
             * with different arguments, creating a new component image 
             * each time. 
             * The only proper method to destroy a Services obtained 
             * from this interface is to pass it to releaseServices.
             * 
             * @param selfInstanceName the Component instance name,
             * as it will appear in the framework.
             * 
             * @param selfClassName the Component type of the 
             * calling program, as it will appear in the framework. 
             * 
             * @param selfProperties (which can be null) the properties 
             * of the component image to appear. 
             * 
             * @throws CCAException in the event that selfInstanceName 
             * is already in use by another component.
             * 
             * @return  A Services object that pertains to the
             *	    image of the this component. This is identical
             *	    to the object passed into Component.setServices() 
             *	    when a component is created.
             */
            [OperationContract]
			[ServiceKnownType(typeof(TypeMapImpl))]
			//[ServiceKnownType(typeof(WorkerServicesImpl2))]
			Services getServices(string selfInstanceName, string selfClassName,
                         TypeMap selfProperties);// throws CCAException ;


            /** 
             * Inform framework that the <code>Services</code> handle is no longer needed by the 
             * caller and that the reference to its component image is to be
             * deleted from the context of the underlying framework. This invalidates
             * any <code>ComponentID</code>'s or <code>ConnectionID</code>'s associated 
             * with the given <code>Services</code>' component image. 
             * 
             * @param services The result of getServices earlier obtained.
             * 
             * @throws CCAException if the <code>Services</code>
             *         handle has already been released or is otherwise rendered invalid 
             *         or was not obtained from <code>getServices()</code>.
             */
            void releaseServices(Services services);// throws CCAException ;


            /** 
             * Tell the framework it is no longer needed and to clean up after itself. 
             *  @throws CCAException if the framework has already been shutdown.
             */
            void shutdownFramework();// throws CCAException;

            /** 
             * Creates a new framework instance based on the same underlying 
             * framework implementation. This does not copy the existing 
             * framework, nor are any of the user-instantiated components in
             * the original framework available in the newly created 
             * <code>AbstractFramework</code>. 
             * 
             * @throws CCAException when one of the following conditions occur:
             * 
             * (1)the AbstractFramework previously had shutdownFramework() called on it, or 
             * (2)the underlying framework implementation does not permit creation 
             * of another instance.	 
             */
            AbstractFramework createEmptyFramework();// throws CCAException;

        }  // end interface AbstractFramework

        /**
         *  This interface describes a CCA connection between components.
         *  A connection is made at the users direction
         *  when one component provides a Port that another component
         *  advertises for and uses.  The components are referred to by their
         *  opaque ComponentID references and the Ports are referred to
         *  by their string instance names.
         */

		[DataContract]
		[KnownType(typeof(WorkerConnectionIDImpl))]
        public abstract class ConnectionID
        {
            /** 
             *  Get the providing component (callee) ID.
             *  @return ComponentID of the component that has 
             *          provided the Port for this connection. 
             *  @throws CCAException if the underlying connection 
             *            is no longer valid.
             */
            public abstract ComponentID getProvider();// throws CCAException ;

            /** 
             *  Get the using component (caller) ID.
             *  @return ComponentID of the component that is using the provided Port.
             *  @throws CCAException if the underlying connection is no longer valid.
             */
            public abstract ComponentID getUser();// throws CCAException ; 

            /** 
             *  Get the port name in the providing component of this connection.
             *  @return the instance name of the provided Port.
             *  @throws CCAException if the underlying connection is no longer valid.
             */
            public abstract string getProviderPortName();// throws CCAException ; 

            /** 
             *  Get the port name in the using component of this connection.
             *  Return the instance name of the Port registered for use in 
             *  this connection.
             *  @throws CCAException if the underlying connection is no longer valid.
             */
            public abstract string getUserPortName();// throws CCAException ; 

        }

        /** 
         *  An opaque reference to a Component Class.  
         *  (This interface is expected to grow substantially.)
         */
        [Serializable]
		public abstract class ComponentClassDescription
        {

            /** 
             *  Returns the class name provided in 
             *   <code>BuilderService.createInstance()</code>
             *   or in
             *   <code>AbstractFramework.getServices()</code>.
             *  <p>
             *  Throws <code>CCAException</code> if <code>ComponentClassDescription</code> is invalid.
             */
            public abstract string getComponentClassName();// throws CCAException ;

        }  // end interface ComponentClassDescription

        /**
         * some standard (required) CCA ports.
         */
        namespace ports
        {

            /**
             * Go, component, go!
             */
			[ServiceContract]
			[ServiceKnownType(typeof(GoPortWrapper))]
            public interface GoPort : Port
            {
                /** 
                 * Execute some encapsulated functionality on the component. 
                 * Return 0 if ok, -1 if internal error but component may be 
                 * used further, and -2 if error so severe that component cannot
                 * be further used safely.
                 */
				[OperationContract]
                int go();
            }

            /** 
             * The minimum kinds of events needed. List to be extended
             * in the future.  Clearly, SMP architectures and threads may
             * violate the simple assumptions.
             */
            enum EventType
            {
                Error = -1,            // Someone got a bogus event object somehow.
                ALL = 0,               // Component wants to receive all event notices. 
                // ALL itself never received.
                ConnectPending = 1,    // A connection is about to be attempted.
                Connected = 2,         // A connection has been made.
                DisconnectPending = 3, // A disconnection is about to be attempted.
                Disconnected = 4,      // A disconnection has been made.
            }

            /**
             * Event created when two components are connected.
             */
            interface ConnectionEvent
            {

                /** 
                 * <p>Returns the integer from those enumerated that describes the event.</p>
                 * 
                 * <p>
                 * The semantics are noted before
                 * each member of the enum/static constant. We can add in different
                 * types of connect/disconnect as multiports and
                 * explicit local/global/sync/async semantics are agreed to in the future.
                 * At present we assume that:
                 * <ul>
                 * <li> All instances in a component cohort (often thought of as a single
                 *   "parallel component") receive all the events
                 *   and in the same order, but not necessarily globally synchronously.
                 *
                 * <li> For disconnections, within a process the events are delivered first
                 *   to the using component then (if necessary) to the providing
                 *   component.
                 * 
                 * <li> For connections, within a process the events are delivered first
                 *   to the providing component then (if necessary) to the using
                 *   component.
                 * </ul>
                 * </p>
                 * 
                 * <p>
                 * Clearly some of the assumptions above may not suit a component
                 * instance in which multiple execution threads act on a
                 * single instance of the <code>cca.Services</code> object (SMP). The Services
                 * specification is ambiguous as to whether such a component is even
                 * allowed.
                 * </p>
                 * <p>
                 * When this is clarified, additional members of the enum may arise,
                 * in which case the assumptions here apply only to
                 * <code>ConnectPending</code>, <code>Connected</code>, <code>DisconnectPending</code>, 
                 * <code>Disconnected</code> types.
                 */
                EventType getEventType();

                /** 
                 * Get Properties of the affected Port.
                 * Among the standard properties are the name and type info.
                 * The keys are cca.portName, cca.portType.
                 */
                cca.TypeMap getPortInfo();
            }

            /**
             * This is the interface that a component must provide in order to 
             * be notified of <code>ConnectEvents</code>.
             */
            interface ConnectionEventListener
            {

                /** 
                 * Called on all listeners when a connection is made or broken. 
                 */
                void connectionActivity(ConnectionEvent ce);
            }

            /**
             * Connection event service.
             */
            interface ConnectionEventService : cca.Port
            {

                /** 
                 * Sign up to be told about connection activity.
                 * connectionEventType must be one of the integer 
                 * values defined iN ConnectionEvent. 
                 */
                void addConnectionEventListener(EventType et,
                                ConnectionEventListener cel);

                /** 
                 * Ignore future ConnectionEvents of the given type.
                 * connectionEventType must be one of the integer values 
                 * defined in ConnectionEvent. 
                 */
                void removeConnectionEventListener(EventType et,
                                   ConnectionEventListener cel);
            }

            /** 
             *    BuilderService is a Port implemented by a CCA compliant framework for
             * the purpose of composing components into applications in a standard way.
             * It is meant to expose the Component creation and composition functionality
             * without the specific framework implementation. This interface is expected 
             * to be useful for rapid application development in a scripting language. 
             * Other uses are generic application development environments for CCA 
             * applications. 
             * <p>Each of the fundamental component architecture pieces
             *    (instances of Component, Port, and Connection) may have
             *    an associated TypeMap of properties managed by the framework.
             *    The standardized keys in the properties of a Port are documented
             *    in Services.getPortProperties().
             *    The standardized keys in the properties of a Component and Connection
             *    are documented below.
             *  </p>
             *  <p>For connection, thus far:
             *    <pre>
             *    Key         value           meaning
             *    cca.isInUse boolean         true if there have been more successful
             * 				 getPort than releasePort calls for the
             * 				 connection at the the time 
             * 				 properties were fetched.
             *   </pre>
             *   </p>
             *  <P>For component, thus far:
             *   <pre>
             *    Key                 value           meaning
             *    cca.className       string          component type
             *   </pre>
             *  </p>
             */
			[ServiceContract]
            public interface BuilderService : cca.Port
            {

                /**
                 * 	Creates an instance of a CCA component of the type defined by the 
                 * 	string className.  The string classname uniquely defines the
                 * 	"type" of the component, e.g.
                 * 	    doe.cca.Library.GaussianElmination. 
                 * 	It has an instance name given by the string instanceName.
                 * 	The instanceName may be empty (zero length) in which case
                 * 	the instanceName will be assigned to the component automatically.
                 * 	@throws CCAException If the Component className is unknown, or if the
                 * 		instanceName has already been used, a CCAException is thrown.
                 * 	@return A ComponentID corresponding to the created component. Destroying
                 * 		the returned ID does not destroy the component; 
                 * 		see destroyInstance instead.
                 */
				[OperationContract]
                cca.ComponentID createInstance(string instanceName, string className, cca.TypeMap properties);
                //throws cca.CCAException ; 

                /** 
                 *  Get component list.
                 *  @return a ComponentID for each component currently created.
                 */
                cca.ComponentID[] getComponentIDs();// throws cca.CCAException ; 

                /** 
                 *  Get property map for component.
                 *  @return the public properties associated with the component referred to by
                 *  ComponentID. 
                 *  @throws a CCAException if the ComponentID is invalid.
                 */
                cca.TypeMap getComponentProperties(cca.ComponentID cid);
                //throws cca.CCAException ;

                /**
                 * 	Causes the framework implementation to associate the given properties 
                 * 	with the component designated by cid. 
                 * 	@throws CCAException if cid is invalid or if there is an attempted
                 * 	change to a property locked by the framework implementation.
                 */
                void setComponentProperties(cca.ComponentID cid, cca.TypeMap map);
                //throws cca.CCAException ;

                /** Get component id from stringified reference.
                 *    @return a ComponentID from the string produced by 
                 * 	ComponentID.getSerialization(). 
                 *    @throws CCAException if the string does not represent the appropriate 
                 * 	 serialization of a ComponentID for the underlying framework.
                 */
                cca.ComponentID getDeserialization(string s);// throws cca.CCAException ;

                /** Get id from name by which it was created.
                 *  @return a ComponentID from the instance name of the component
                 *  produced by ComponentID.getInstanceName().
                 *  @throws CCAException if there is no component matching the 
                 *  given componentInstanceName.
                 */
                cca.ComponentID getComponentID(string componentInstanceName);
                //throws cca.CCAException ;

                /** 
                 *  Eliminate the Component instance, from the scope of the framework.
                 *  @param toDie the component to be removed.
                 *  @param timeout the allowable wait; 0 means up to the framework.
                 *  @throws CCAException if toDie refers to an invalid component, or
                 *  if the operation takes longer than timeout seconds.
                 */
				[OperationContract]
                void destroyInstance(cca.ComponentID toDie, float timeout);
                //throws cca.CCAException ;

                /** 
                 *  Get the names of Port instances provided by the identified component.
                 *  @param cid the component.
                 *  @throws CCAException if cid refers to an invalid component.
                 */
				[OperationContract]
				string[] getProvidedPortNames(cca.ComponentID cid);
                //throws cca.CCAException ; 

                /** 
                 *  Get the names of Port instances used by the identified component.
                 *  @param cid the component.
                 *  @throws CCAException if cid refers to an invalid component. 
                 */
				[OperationContract]
				string[] getUsedPortNames(cca.ComponentID cid);
                //throws cca.CCAException ; 

                /** 
                 *  Fetch map of Port properties exposed by the framework.
                 *  @return the public properties pertaining to the Port instance 
                 *    portname on the component referred to by cid. 
                 *  @throws CCAException when any one of the following conditions occur:<ul>
                 *    <li>portname is not a registered Port on the component indicated by cid,
                 *    <li>cid refers to an invalid component. </ul>
                 */
                cca.TypeMap getPortProperties(cca.ComponentID cid, string portName);
                //throws cca.CCAException ;

                /** 
                 *  Associates the properties given in map with the Port indicated by 
                 *  portname. The component must have a Port known by portname.
                 *  @throws CCAException if either cid or portname are
                 *	invalid, or if this a changed property is locked by 
                 *	 the underlying framework or component.
                 */
                void setPortProperties(cca.ComponentID cid, string portName,
                           cca.TypeMap map);// throws cca.CCAException ;

                /**
                 *   Creates a connection between ports on component user and 
                 *   component provider. Destroying the ConnectionID does not
                 *   cause a disconnection; for that, see disconnect().
                 *   @throws CCAException when any one of the following conditions occur:<ul>
                 *   <li>If either user or provider refer to an invalid component,
                 *   <li>If either usingPortName or providingPortName refer to a 
                 * 	 nonexistent Port on their respective component,
                 *   <li>If other-- In reality there are a lot of things that can go wrong 
                 * 	 with this operation, especially if the underlying connections 
                 * 	 involve networking.</ul>
                 */
				[OperationContract]
                cca.ConnectionID connect(cca.ComponentID user,
                             string usingPortName,
                             cca.ComponentID provider,
                             string providingPortName);
                //throws cca.CCAException ; 

                /** Returns a list of connections as an array of 
                 * 	handles. This will return all connections involving components 
                 * 	in the given componentList of ComponentIDs. This
                 * 	means that ConnectionID's will be returned even if only one 
                 * 	of the participants in the connection appears in componentList.
                 * 
                 * 	@throws CCAException if any component in componentList is invalid.
                 */
                cca.ConnectionID[] getConnectionIDs(cca.ComponentID[] componentList);
                //throws cca.CCAException ; 

                /**
                 *   Fetch property map of a connection.
                 *   @returns the properties for the given connection.
                 *   @throws CCAException if connID is invalid.
                 */
                cca.TypeMap getConnectionProperties(cca.ConnectionID connID);
                //throws cca.CCAException ;

                /** Associates the properties with the connection.
                 *   @param map the source of the properties.
                 *   @param connID connection to receive property values.
                 *   @throws CCAException if connID is invalid, or if this changes 
                 *	 a property locked by the underlying framework.
                 */
                void setConnectionProperties(cca.ConnectionID connID, cca.TypeMap map);
                //throws cca.CCAException ;

                /** Disconnect the connection indicated by connID before the indicated
                 *     timeout in secs. Upon successful completion, connID and the connection
                 *     it represents become invalid. 
                 *     @param timeout the time in seconds to wait for a connection to close; 0
                 *     means to use the framework implementation default.
                 *     @param connID the connection to be broken.
                 *     @throws CCAException when any one of the following conditions occur: <ul>
                 *     <li>id refers to an invalid ConnectionID,
                 *     <li>timeout is exceeded, after which, if id was valid before 
                 * disconnect() was invoked, it remains valid
                 * </ul>
                 * 
                 */
				[OperationContract]
				void disconnect(cca.ConnectionID connID, float timeout);
                //throws cca.CCAException ; 

                /** Remove all connections between components id1 and id2 within 
                 *   the period of timeout secs. If id2 is null, then all connections 
                 *   to id1 are removed (within the period of timeout secs).
                 *   @throws CCAException when any one of the following conditions occur:<ul>
                 *	  <li>id1 or id2 refer to an invalid ComponentID (other than id2 == null),
                 *	  <li>The timeout period is exceeded before the disconnections can be made. 
                 *	  </ul>
                 */
                void disconnectAll(cca.ComponentID id1, cca.ComponentID id2,
                           float timeout);// throws cca.CCAException ; 

            } // end interface BuilderService

            /** 
             *  ComponentRepository is a Port implemented by a CCA compliant framework 
             *  or other component to expose in a standard way:<ol>
             *  <li>immediately instantiable component classes.
             *  <li>component class property maps. 
             *  <li>the operations used to obtain more component classes at runtime.
             *  </ol>
             *   
             */
            public interface ComponentRepository : cca.Port
            {

                /** 
                 *  Collect the currently obtainable class name strings from
                 *  factories known to the builder and the from the
                 *  already instantiated components.
                 *  @return The list of class description, which may be empty, that are
                 *   known a priori to contain valid values for the className
                 *  argument of createInstance. 
                 *  @throws CCAException in the event of error.
                 */
                cca.ComponentClassDescription[] getAvailableComponentClasses();
                //throws cca.CCAException ;

            } // end of cca.ports.ComponentRepository

            /**
             * ServiceProvider interface implements a non-singleton service Port.
             * It is a port type that can be exported as normal or to the
             * framework exclusively by using the ServiceRegistry port.
             * This is the Port interface that is implemented by 
             * a component wishing to provide a service for other 
             * components.  The behavior is as follows:  
             *
             * 1. The component registers for a ServiceRegistry Port (above) and
             * does a "getPort()" to get it.  
             *
             * 2. It adds a ServiceProvider Port to the ServiceRegistry.
             *
             * 3. When called the component's implementation of ServiceProvider::createService()
             * must create the Port asked for, and addProvidesPort to register it on
             * the component.  createService() returns the Port instance
             * name for this Port just provided.  
             *
             * 4. The framework connects the originating component to the component
             * requesting the service.
             *
             */
            public interface ServiceProvider : cca.Port
            {
                /**
                * Create the Port for the Service, informing the framework through
                * "addProvidesPort()" on the originating component.
                * @return the name of the port created.
                */
                string createService(string portType);// throws cca.CCAException ;

                /** Informs the originating component that the instance of the
                * provided service is no longer needed. The ServiceProvider
                * can now safely removePort on the named port.
                */
                void destroyService(string portName);// throws cca.CCAException ;

            }

            /**
             * ServiceRegistry is a Port that is provided by the framework
             * and can be used by a component wishing to provide service Ports. 
             */
            public interface ServiceRegistry : cca.Port
            {
                /**
                * Add a ServiceProvider that can be asked to produce service Port's
                * for other components to use subsequently.
                * True means success. False means that for some reason, the
                * provider isn't going to function. Possibly another server is doing
                * the job.
                */
                bool addService(string serviceType, ServiceProvider portProvider);// throws cca.CCAException ;

                /** Add a "reusable" service gov.cca.Port for other components to use 
                * subsequently.
                */
                bool addSingletonService(string serviceType, gov.cca.Port server);// throws cca.CCAException ;

                /** Inform the framework that this service Port is no longer to
                * be used, subsequent to this call. 
                */
                void removeService(string serviceType);// throws cca.CCAException ;

            }

            //########### ################## ################## ##################
            // half the file is devoted to parameter ports in a multilanguage tool

            ///////////////////////////////////////////////////////////////////////
            /** This type of interface is exported for manipulation by other
                components or by a user-interface (UI) (text or graphic).
                This version of the Port is so simple that mere mortal component
                writers could implement it.
                It is not nearly so self-documenting at runtime as the
                full-service ParameterPort.
             */
            interface BasicParameterPort : gov.cca.Port
            {

                /** Return a TypeMap of runtime configuration parameters. 
                    It is recommended that the map returned be a clone/copy of the
                    a privately held map, not a shared object reference.
                 */
                gov.cca.TypeMap readConfigurationMap();// throws gov.cca.CCAException;

                /** Copy the parameter values given in map into the
                    internal map, for those parameters which
                    are already defined by the internal map.
                    The outsider does not get to cause arbitrary
                    keys to be copied into the internal map.
                    @throws gov.cca.CCAException if TypeMap operations fail.
                 */
                void writeConfigurationMap(gov.cca.TypeMap map);// throws gov.cca.CCAException;

                /** Fetch the list of keys in the TypeMap that are
                    for public configuration purposes. Other values found in
                    the TypeMap must not be changed.
                 */
                string[] readConfigurationKeys();

            } // end BasicParameterPort

            ///////////////////////////////////////////////////////////////////////
            /** This type of interface is exported for manipulation by other
                components or by a user-interface (UI) (text or graphic).
                By using the port ParameterFactory the component
                writer never actually has to implement this port directly.
                The recommended instance name for this port type is "CONFIG",
                if a component provides only one such port. 
                Component assembly or user interface rendering agents might 
                assume this name. However, clever agents will act based on
                port type rather than port instance name.

                Data types represented: Anything representable in a TypeMap.
                The following auxiliary information is managed for the benefit
                of component end-user, UI, and other agents. 
                Per map:
                - title -- a name suitable to a top level window frame.
                - group names -- data items are put in subsets (groups)
                                 as, for example, in tabbed dialogs.
                - list of all published parameter keys, those defined
                  with the add functions of ParameterPortFactory. 
                Per group name:
                - group title -- ui-appropriate subset title, typically a tab heading.
                - group keys -- list of data item keys in a named group.
                Per data item key:
                - default value 
                - current value -- queryable directly from TypeMap by key name.
                - help string -- potentially long-winded explanation of parameter use.
                - prompt string -- shorter than help string and usually shown
                                   in UI somehow while soliciting input.
                - numeric bounds or value choice list. Where data type is
                  an array type, the choice or bound restrictions are applied
                  element-wise.


                Special notes:
                - The rendering of array-valued parameters in UI's poses a variety
                of thorny problems in human-computer interaction. Use of
                array parameters should be considered carefully. Not all UI
                agents may be able to render array-valued parameters.
                - Keys in the TypeMap with names starting with "gcpPPF." are
                  reserved for private use by the 
                  ParameterPortFactory implementation.
             */
            interface ParameterPort : BasicParameterPort
            {

                // Reminders: inheritted from BasicParameterPort
                //    gov.cca.TypeMap readConfigurationMap();
                //    void writeConfigurationMap(gov.cca.TypeMap map);
                //    string[] readConfigurationKeys();

                /** Fetch configuration title. 
                    @return Description of data set.
                 */
                string readTitle();

                /** Fetch the names of groups. Each page in a tabbed dialog
                    goes with a group, for example. Group names should be
                    a simple word without whitespace.
                  */
                string[] readGroupNames();

                /** Fetch UI-appropriate name for group.
                    Group name and group title may be the same, if simple.
                    Group title can be complex if desired.
                    @throws gov.cca.CCAException if groupName is unknown.
                 */
                string readGroupTitle(string groupName);// throws gov.cca.CCAException ;

                /** Fetch data item keys associated with groupName.
                    Array order will be the same as the order in which
                    the additions were made in the ParameterPortFactory interface.
                    @throws gov.cca.CCAException if groupName is unknown.
                 */
                string[] readGroupKeys(string groupName);// throws gov.cca.CCAException;

                /** Fetch the help string for key.
                    @throws gov.cca.CCAException if key is unknown.
                 */
                string readHelp(string key);// throws gov.cca.CCAException;

                /** Fetch the prompt string for key.
                    @throws gov.cca.CCAException if key is unknown.
                 */
                string readPrompt(string key);// throws gov.cca.CCAException;

                /** By default, bounds are defined except for complex numbers
                    booleans, and strings. On array types, bounds apply
                    element-wise. i.e.  low <= arr[i] <= high for all i.
                    @return true if simple bounds are defined for a key.
                    @throws gov.cca.CCAException if key is unknown.
                 */
                bool hasBounds(string key);// throws gov.cca.CCAException;

                /** By default, lists of choices are not defined for scalars or arrays.
                    Choices are applied element-wise for array types.
                    I.e. (arr[i] IN choice-set) == true  for all i.
                    @return true if choice list is defined for a key.
                    @throws gov.cca.CCAException if key is unknown.
                 */
                bool hasChoices(string key);// throws gov.cca.CCAException;


                /* The next section defines typed versions for the functions
                   readDefaultTYPE
                   readBoundsTYPE bounds is a two-element array, low, high for
                                  real and integer types. Bounds are not currently
                                  supported for complex numbers.
                   readChoicesTYPE choices is an array of acceptable values,
                        in the order of definition in ParameterPortFactory.
                   Where type may be an array or a scalar.
                 */

                /** Fetch the default for boolean-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                bool readDefaultBoolean(string key);// throws gov.cca.CCAException;

                /** Fetch the default for string-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                string readDefaultString(string key);// throws gov.cca.CCAException;

                /** Fetch the default for integer-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                int readDefaultInt(string key);// throws gov.cca.CCAException;

                /** Fetch the default for long-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                long readDefaultLong(string key);// throws gov.cca.CCAException;

                /** Fetch the default for float-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                float readDefaultFloat(string key);// throws gov.cca.CCAException;

                /** Fetch the default for double-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                double readDefaultDouble(string key);// throws gov.cca.CCAException;

                /** Fetch the default for fcomplex-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                ///////fcomplex readDefaultFcomplex(string key);// throws gov.cca.CCAException;

                /** Fetch the default for dcomplex-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                ///////dcomplex readDefaultDcomplex(string key);// throws gov.cca.CCAException;


                /** Fetch the default for string-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                string[] readDefaultStringArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for boolean-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                bool[] readDefaultBooleanArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for integer-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                int[] readDefaultIntArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for long-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                long[] readDefaultLongArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for float-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                float[] readDefaultFloatArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for double-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                double[] readDefaultDoubleArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for fcomplex-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                //fcomplex[] readDefaultFcomplexArray(string key);// throws gov.cca.CCAException;

                /** Fetch the default for dcomplex-array-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                //dcomplex[] readDefaultDcomplexArray(string key);// throws gov.cca.CCAException;

                /** Fetch the bounds for integer-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void readBoundsInt(string key, out int low, out int high);// throws gov.cca.CCAException;

                /** Fetch the bounds for long-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void readBoundsLong(string key, out long low, out long high);// throws gov.cca.CCAException;

                /** Fetch the bounds for float-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void readBoundsFloat(string key, out float low, out float high);// throws gov.cca.CCAException;

                /** Fetch the bounds for double-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void readBoundsDouble(string key, out double low, out double high);// throws gov.cca.CCAException;

                /** Fetch the choices for string-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                string[] readChoicesString(string key);// throws gov.cca.CCAException;

                /** Fetch the choices for integer-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                int[] readChoicesInt(string key);// throws gov.cca.CCAException;

                /** Fetch the choices for long-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                long[] readChoicesLong(string key);// throws gov.cca.CCAException;

                /** Fetch the choices for float-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                float[] readChoicesFloat(string key);// throws gov.cca.CCAException;

                /** Fetch the default for double-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                double[] readChoicesDouble(string key);// throws gov.cca.CCAException;

                /** Fetch the choices for fcomplex-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                //fcomplex[] readChoicesFcomplex(string key);// throws gov.cca.CCAException;

                /** Fetch the choices for dcomplex-typed key. 
                    @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                //dcomplex[] readChoicesDcomplex(string key);// throws gov.cca.CCAException;


            } // end interface ParameterPort

            ///////////////////////////////////////////////////////////////////////
            /** This interface supercedes the ccaffeine 
             * ConfigurableParameterPortFactory,
             * the parameters library, and all the associated cruft that
             * gunked up a component. The component writer now just needs to
             * use this port and one or more typemaps.
             *
             * All the function names and meanings are as identical to
             * the existing ccaffeine interfaces as possible. Most just have
             * a TypeMap argument added and modernized (stl) string usage.
             * Additional functions to support the full generality of TypeMap
             * have been added.
             *
             * Each ParameterPort is defined on a typemap the component owns.
             * A component writer can define more than one such port for a component,
             * and each will show up as a ParameterPort for UI agents.
             * The component writer can choose to be notified of 
             * parameter reads and writes using the related Listener interfaces.
             *
             * All strings (help, prompt, value, etc) passed to this 
             * interface must be free
             * of \n and other line-breaking characters if certain
             * ancient gui clients are going to be used. This limitation is
             * in the clients rather than the ParameterPort implementation.
             * Those clients are prone to compressing redundant whitespace 
             * as well. In a rosy future, these client limitations will go away.
             */
            interface ParameterPortFactory : gov.cca.Port
            {
                /** Initialize the portData for use in a ParameterPort
                 *  with name portName.
                 *  More than one such port can be defined.
                 *  The given string portName will be cached in the TypeMap
                 *  as the result of this function and must not be changed
                 *  by the component henceforth.
                 *  
                 *  @param portData the user-supplied TypeMap associated with the port;
                 *       It is somehow shared between the ParameterPortFactory
                 *       and the component. The ParameterPortFactory will
                 *       not read or change preexisting values in portData except those
                 *       requested via the addRequest functions and those
                 *       keys starting with the reserved prefix "gcpPPF.".
                 *  @param portName The name of the ParameterPort to appear in
                 *       the component. It must not conflict with other port
                 *       names in the same component. The port name "CONFIG"
                 *       is recommended if only one ParameterPort is being defined.
                 *  
                 **/
                void initParameterData(gov.cca.TypeMap portData, string portName);

                /** Define the window title for the parameter UI dialog.
                 **/
                void setBatchTitle(gov.cca.TypeMap portData, string title);

                /** Define the next tab/group title to use. All
                 * addRequest subsequent calls will add to this group.
                 * Multiple dialog tabs/groups can be defined in this way.
                 * @param newGroupName a one-word name for the group.
             * @param portData the hash-table which we're subsetting
             * with a tab notation.
                 */
                void setGroupName(gov.cca.TypeMap portData, string newGroupName);

                /** Define the next tab/group title to use. All
                 * addRequest subsequent calls will add to this group.
                 * Multiple dialog tabs/groups can be defined in this way.
             * @param portData the hash-table which we're subsetting
             * with a tab notation.
                 * @param newGroupName a one-word name for the group.
                 * @param groupTitle an optional title for the group.
                 */
                ////////////////// void setGroupName[AndTitle](gov.cca.TypeMap portData, string newGroupName, string groupTitle);
                void setGroupName(gov.cca.TypeMap portData, string newGroupName, string groupTitle);

                /** Define a boolean parameter and its default state.
                 * The configured value is always available by
                 * portData.getBool(name, ...);
                 * @throws gov.cca.CCAException if key is known and mistyped.
                 */
                void addRequestBoolean(gov.cca.TypeMap portData,
                                       string name,
                                       string help,
                                       string prompt,
                                       bool bdefault);// throws gov.cca.CCAException;

                /** Define a int parameter and its default state.
                 * The configured value is always available by
                 * portData.getInt(name, ...) and it will be
                 * in the range [low, high]. The initially given bounds
                 * can be replaced with a choice list later.
                 * @throws gov.cca.CCAException if key is known and mistyped.
                 */
                void addRequestInt(gov.cca.TypeMap portData,
                                   string name,
                                   string help,
                                   string prompt,
                                   int idefault,
                                   int low,
                                   int high);// throws gov.cca.CCAException;

                /** Define a long parameter and its default state.
                 * The configured value is always available by
                 * portData.getLong(name, ...) and it will be
                 * in the range [low, high]. The initially given bounds
                 * can be replaced with a choice list later.
                 * @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void addRequestLong(gov.cca.TypeMap portData,
                                    string name,
                                    string help,
                                    string prompt,
                                    long ldefault,
                                    long low,
                                    long high);// throws gov.cca.CCAException;

                /** Define a float parameter and its default state.
                 * The configured value is always available by
                 * portData.getFloat(name, ...) and it will be
                 * in the range [low, high]. The initially given bounds
                 * can be replaced with a choice list later.
                 * @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void addRequestFloat(gov.cca.TypeMap portData,
                                     string name,
                                     string help,
                                     string prompt,
                                     float fdefault,
                                     float low,
                                     float high);// throws gov.cca.CCAException;

                /** Define a double parameter and its default state.
                 * The configured value is always available by
                 * portData.getDouble(name, ...) and it will be
                 * in the range [low, high]. The initially given bounds
                 * can be replaced with a choice list later.
                 * @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void addRequestDouble(gov.cca.TypeMap portData,
                                      string name,
                                      string help,
                                      string prompt,
                                      double ddefault,
                                      double low,
                                      double high);// throws gov.cca.CCAException;

                /** Define a string parameter and its default state.
                 * The configured value is always available by
                 * portData.getString(name, ...).
                 * If no addRequestStringChoice calls are made, the
                 * user input may be any string. If addRequestStringChoice
                 * is used, the value will be one among the choices.
                 * If addRequestStringChoice is used, deflt must
                 * be among the choices defined.
                 * @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void addRequestString(gov.cca.TypeMap portData,
                                      string name,
                                      string help,
                                      string prompt,
                                      string sdefault);// throws gov.cca.CCAException;

                /** Define a new choice for a string parameter.
                 *  If no calls to this function are made for a given
                 *  name, then any form of string will be acceptable input.
                 * @throws gov.cca.CCAException if key is unknown or mistyped.
                 */
                void addRequestStringChoice(gov.cca.TypeMap portData,
                                            string key,
                                            string choice);// throws gov.cca.CCAException;

                /** As addRequestStringChoice, but in bulk. */
                void addStringChoices(gov.cca.TypeMap portData,
                                      string name,
                                      string[] choices);// throws gov.cca.CCAException;

                /** Replace the bounds on the named parameter by a list. */
                void addIntChoices(gov.cca.TypeMap portData,
                                   string name,
                                   int[] choices);// throws gov.cca.CCAException;

                /** Replace the bounds on the named parameter by a list. */
                void addLongChoices(gov.cca.TypeMap portData,
                                    string name,
                                    long[] choices);// throws gov.cca.CCAException;

                /** Replace the bounds on the named parameter by a list. */
                void addFloatChoices(gov.cca.TypeMap portData,
                                     string name,
                                     float[] choices);// throws gov.cca.CCAException;

                /** Replace the bounds on the named parameter by a list. */
                void addDoubleChoices(gov.cca.TypeMap portData,
                                      string name,
                                      double[] choices);// throws gov.cca.CCAException;

                /** Replace the bounds on the named parameter by a list. */
                /** void addFcomplexChoices(gov.cca.TypeMap portData,
                                        string name, 
                                        fcomplex[] choices);// throws gov.cca.CCAException;
            */
                /** Replace the bounds on the named parameter by a list. */
                /** void addDcomplexChoices(gov.cca.TypeMap portData,
                                        string name, 
                                        dcomplex[] choices);// throws gov.cca.CCAException;
            */
                /** Clear all previously added requests, titles, groups. After
                 *  this call, it is as if the ParameterPort has
                 *  seen initParameterData but otherwise never configured.
                 *  The values of
                 *  previously defined parameters (but not bounds, etc)
                 *  remain in the TypeMap.
                 *  Typically, this is used only by someone implementing
                 *  the updateParameterPort function from
                 *  interface ParameterGetListener.
                 */
                void clearRequests(gov.cca.TypeMap portData);

                /** 
                 * Register listener (the component) that wishes to have
                 * a chance to change the contents of its ParameterPort
                 * just before the parameters TypeMap, portData, is read.
                 * @param powner a pointer to the listener that will be
                 * forgotten when it is no longer needed. 
             * @param portData the hash-table being accessed.
                 */
                void registerUpdater(gov.cca.TypeMap portData,
                                     ParameterGetListener powner);

                /** Register listener (the component) if it wishes to be
                 * informed when an parameter is changed via writeConfigurationMap.
                 * Listeners are called after values are set.
                 */
                void registerUpdatedListener(gov.cca.TypeMap portData,
                                             ParameterSetListener powner);

                /** Signal that the ParameterPort is fully defined and should
                 * now pop out on the component.
                 * The component is free to hold the portData map internally
                 * without adding it until some desired time.
                 * The Services passed here
                 * must be the component's own Services handle.
                 * The ParameterPortFactory takes care of addProvidesPort.
                 */
                void addParameterPort(gov.cca.TypeMap portData,
                                      gov.cca.Services services);

                /** Cause a previously defined parameter port to go away.
                 * This function should be called at component shutdown
                 * (setService(0)) time for any parameter ports that have
                 * been added but not yet removed.
                 * The ParameterPortFactory takes care of removeProvidesPort.
                 * This does not change the parameter values in the
                 * TypeMap.
                 */
                void removeParameterPort(gov.cca.TypeMap portData,
                                         gov.cca.Services services);

            } // end interface ParameterPortFactory

            ///////////////////////////////////////////////////////////////////////
            /** This interface is typically implemented by a 
              * component writer using the ParameterPortFactory
              * in a very dynamic fashion. Most component writers don't
              * need it.
              *  
              *  The ParameterGet listeners are called when
              *  the readMap function is called on
              *  the ParameterPort interface. 
              *  The listener (usually the component owning the typemap) can change the 
              *  contents (title, groups, parameters) of the ParameterPort
              *  in their updateParameterPort function. These changed
              *  values will be returned to the caller (framework/gui).
              *  
              *  This is handy when the contents of one ParameterPort depend
              *  on values already set in another ParameterPort
              *  on the same component. E.g. selection of a particular chemical
              *  reaction mechanism in the first ParameterPort defines the
              *  set of chemical species that need initial-concentrations defined
              *  in the second ParameterPort.
              *
              *  The fact that looking at a ParameterPort
              *  gives an opportunity for it to change will lead to Heisenbugs
              *  in the hands of an inept programmer.
              *
              *  The name of the parameter port which is being used is passed
              *  so the component using the ParameterPortFactory to manage more 
              *  than one Parameter port can tell which one is being updated.
              *
              *  The component should return TRUE if the contents of the
              *  parameter port were changed (cleared or added to) in the
              *  update function or if the component wants to receive all fresh input
              *  for current values.
              * 
              *  @see ParameterSetListener
             */
            interface ParameterGetListener
            {

                /** Inform the listener that someone is about to fetch their 
                 * typemap. The return should be true if the listener
                 * has changed the ParameterPort definitions.
                 */
                bool updateParameterPort(string portName);

            } // end interface ParameterGetListener

            ///////////////////////////////////////////////////////////////////////
            /** This interface is typically implemented by a 
              * component writer using the ParameterPortFactory in a dynamic
              * fashion.
              *   The ParameterSet listener is called after the writeMap
              *   function is called so the component can react to configuration
              *   changes.
              *   @see ParameterGetListener
              */
            interface ParameterSetListener
            {

                /** The component wishing to be told after a parameter is changed
                 * implements this function.
                 * @param portName the name of the port (typemap) on which the
                 * value was set.
                 * @param fieldName the name of the value in the typemap.
                 */
                void updatedParameterValue(string portName, string fieldName);
            } // end interface ParameterSetListener

            //########### ################## ################## ##################

        } // end of namespace cca.ports
    } // end of namespace cca
} // end namespace gov
