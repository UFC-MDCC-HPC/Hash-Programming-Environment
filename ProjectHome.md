# What is HPE ? #

---


HPE is a prototype of component infrastructure that targets distributed-memory parallel computing platforms, used by investigators involved in the [ParGO research group](http://www.lia.ufc.br/~pargo) as a substratum for evaluating design alternatives for fully enabling component-based high performance computing (CBHPC) platforms for parallel computing. Most of these investigators are professors and students of the [Master and Doctoral Program in Computer Science (MDCC)](http://www.mdcc.ufc.br) of the [Federal University of Ceará (UFC)](http://www.ufc.br).

HPE complies with the **Hash component model** (#), proposed to make parallelism a primary concern of CBHPC platforms. Also, HPE complies with the CCA specification ([Common Component Architecture](http://www.cca-forum.org)), a standard model developed by computational scientists from a consortium involving DOE national laboratories and universities in USA for the requirements of large-scale applications in their domains of interest. They are the pioneers in the design of CBHPC platforms.

The components that follow the **Hash** component model are called #-components, presenting the following features:

  * **Intrinsic Parallelism**: They are formed by a set of parts, called _units_, each one deployed in a node of the cluster, defining a general notion of parallel component.

  * **Hierarchical Composition**: They may be composed from other #-components through the so-called _overlapping composition_.

  * **Heterogeneity**: They are classified in a finite set of _component kinds_.

Any component infrastructure that supports #-components is called a **Hash** programming system. So, HPE may be viewed as a reference **Hash** programming system, developed for the needs of ParGO researchers.


# Motivations #

---


The **Hash** component model contrasts with other attempts to meet parallel processing and components for improving productivity in the development of large scale high performance computing applications of _computational sciences_ and _engineering_. In the usual attempts, parallelism is introduced as an orthogonal extension to some existing component model. However, in HPC applications, performance penalties may not be ignored as in usual corporative applications to which existing component models have been designed, justifying the proposal of a component model where paralelism and high performance are primary concerns in the design of component infrastructures.


# Architecture #

---


HPE is composed by three services: **Front-End**, **Back-End**, and **Core**:

  * The **Back-End** offers deployment and execution of #-components in a parallel computing platform. In practice, it may be viewed as a CCA framework enabled for distributed-memory parallelism implemented on top of [Mono/CLI](http://www.mono-project.org).

  * The **Core** offers a distributed library of #-components, providing a uniform view of #-components stored accross a set of **Locations**.

  * From the **Front-End**, users may control the life cicle of #-components. They may build configurations of #-components by overlapping composition of other #-components or from scratch, belonging to the following component kinds: _environments_, _architectures_, _data structures_, _communicators_, _topologies_, _computations_, _applications_, and _qualifiers_, .

The **Front-End** access the services offered by the **Back-End** and the **Core**, for deploying and executing components and putting them in the public repository. For that, the services of the **Back-End** and **Core** are implemented using Web Services technology.


# Related Works #

---


There are related works that tries to meet components and high performance computing. We emphasize the work of people from the DOE laboratories (USA), in collaboration with academic institutions, with [CCA (Common Component Architecture)](http://www.cca-forum.org), and the work of the [CoreGrid consortium](http://www.coregrid.net) with [Fractal](http://fractal.ow2.org) and [GCM (Grid Component Model)](http://gridcomp.ercim.eu).



# Academic People and Institutions Involved #

---



  * [Prof. Francisco Heron de Carvalho Junior (Pargo/MDCC/UFC)](http://buscatextual.cnpq.br/buscatextual/visualizacv.jsp?id=K4763030P0) - leader

  * [Prof. Rafael Dueire Lins (CIn/UFPE)](http://buscatextual.cnpq.br/buscatextual/visualizacv.jsp?id=K4787034Z8)

  * [Prof. Ricardo Cordeiro Correa (Pargo/MDCC/UFC)](http://buscatextual.cnpq.br/buscatextual/visualizacv.jsp?id=K4782545D2)


## Past and Current Graduate Students ##

  * Wagner Guimarães Al-Alam
    * Doctoral student
  * Jefferson de Carvalho Silva
    * Professor at UFC Quixadá.
    * Doctoral Student
    * Master thesis _"Infraestrutura de Componentes Paralelos para Computação de Alto Desempenho"_ (2008)
  * João Marcelo Uchôa de Alencar
    * Professor at UFC Quixadá
    * Doctoral student
  * Cenez Araújo de Rezende
    * Doctoral student
    * Master thesis _" Avaliação de Desempenho de uma Plataforma de Componentes Paralelos"_ (2011)
  * Anderson Boettge Pinheiro
    * Master student
  * Eduardo Gurgel Pinho
    * Master thesis _"Uma Linguagem de Programação Paralela Orientada a Objetos para Arquiteturas de Memória Distribuída"_ (2012)
  * Thiago Braga Marcilon
    * Doctoral student
    * Master thesis _"Contratos Formais para Derivação e Verificação de Componentes Paralelos"_ (2012)
  * Juliano Efson Norberto Sales
    * Master thesis _"Coordenação e Reconfiguração Dinâmica de Componentes em Plataformas de Computação Paralela"_ (2012)
  * Davi Morais Ferreira  (2011)
    * Master thesis _" Integração de Bibliotecas Científicas a uma Plataforma de Componentes Paralelos"_ (2010)


# Financial Support #

---


  * [CNPq - Conselho Nacional de Desenvolvimento Científico e Tecnológico](http://www.cnpq.br)
    * GRANT #475826/2006-0
    * Title: Programação Baseada em Componentes para Aplicações em Ciências Computacionais   sobre Arquiteturas Paralelas e Distribuídas
    * From 01-Oct-2006 To 30-Sep-2008

  * [CNPq - Conselho Nacional de Desenvolvimento Científico e Tecnológico](http://www.cnpq.br)
    * GRANT #480307/2009-1
    * Title: Programação Paralela Baseada em Componentes para Aplicações de Computação de Alto Desempenho
    * From 01-Nov-2009 To 30-Out-2011

  * [CNPq - Conselho Nacional de Desenvolvimento Científico e Tecnológico](http://www.cnpq.br)
    * GRANT #486021/2011-4
    * Title: Nuvem de Componentes para Computação de Alto Desempenho
    * From 01-Nov-2011 To 30-Out-2013
# Publications #

---


As an academic project, the work with the # component model and HPE has motivated a number of publications in computer science conferences and journals.