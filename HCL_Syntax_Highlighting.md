The editor syntax highlighting for the Hash Configuration Language has been implemented using Eclipse Colorer Plugin, version 0.9.3. The instructions on how to download and install the pluging may be obtained from the plugin's website:

http://colorer.sourceforge.net/eclipsecolorer/index.html

After installation, you can copy the file _hcl.hrc_, available at the _Downloads_ section, to the folder _ECLIPSE/plugin/net.sf.colorer`_`XXXX/colorer/hrc/auto_, where ECLIPSE is your base eclipse folder and XXXX is the version of the **Colorer** plugin. Then, edit the file _proto.hrc_ in the folder _ECLIPSE/plugin/net.sf.colorer`_`XXXX/colorer/hrc_, by adding

```
  <prototype name="hcl" group="main" description="Hash Configuration Language">
    <location link="auto/hcl.hrc"/>
    <filename>/\.hcl$/i</filename>
  </prototype>
```

in the section

```
  <!--  main languages  -->
```

, together with the other language syntax highlighting declarations.

Finally, you can associate the _.hcl_ extension with the **Colorer Editor**, at Windows / Preferences / General / Editors / File Associations.
.