using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration.Install;
using System.Linq;


namespace br.ufc.hpe.backend.DGAC
{
    [RunInstaller(true)]
    public partial class HPEManagerService : Installer
    {
        public HPEManagerService()
        {
            InitializeComponent();
        }
		
        private void serviceProcessInstaller1_AfterInstall(object sender, InstallEventArgs e)
        {

        }

        private void serviceInstaller1_AfterInstall(object sender, InstallEventArgs e)
        {

        }
    }
}
