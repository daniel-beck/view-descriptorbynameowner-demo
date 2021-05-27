package io.jenkins.plugins.view_descriptorbynameowner_demo;

import hudson.Extension;
import hudson.model.View;
import hudson.util.ListBoxModel;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class DemoColumn extends ListViewColumn {
    private String foo;

    @DataBoundConstructor
    public DemoColumn() {
    }

    public String getFoo() {
        return foo;
    }

    @DataBoundSetter
    public void setFoo(String foo) {
        this.foo = foo;
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        public ListBoxModel doFillFooItems(@AncestorInPath View view) {
            return new ListBoxModel().add(view == null ? "BAD: null View" : "GOOD: has View");
        }
    }
}
