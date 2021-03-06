package eu.rcauth.delegserver.oauth2.cli;

import edu.uiuc.ncsa.myproxy.oa4mp.server.admin.permissions.PermissionsStore;
import eu.rcauth.delegserver.storage.DSOA2Client;

import edu.uiuc.ncsa.myproxy.oauth2.tools.OA2ClientCommands;
import edu.uiuc.ncsa.security.core.Identifiable;
import edu.uiuc.ncsa.security.core.Store;
import edu.uiuc.ncsa.security.core.util.MyLoggingFacade;
import edu.uiuc.ncsa.security.delegation.server.storage.ClientApprovalStore;

public class DSOA2ClientCommands extends OA2ClientCommands {

    public DSOA2ClientCommands(MyLoggingFacade logger, String defaultIndent, Store clientStore, ClientApprovalStore clientApprovalStore, PermissionsStore permissionsStore) {
        super(logger, defaultIndent, clientStore, clientApprovalStore, permissionsStore);
    }

    @Override
    protected void longFormat(Identifiable identifiable) {
        super.longFormat(identifiable);

        // add the description when printing the client
        DSOA2Client client = (DSOA2Client) identifiable;
        sayi("description=" + client.getDescription());
    }

    @Override
    public void extraUpdates(Identifiable identifiable) {
        super.extraUpdates(identifiable);

        DSOA2Client client = (DSOA2Client) identifiable;

        // ask for the description when updating / creating the client
        client.setDescription(getInput("enter description", client.getDescription()));
    }

}
