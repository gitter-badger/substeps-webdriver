/*
 *	Copyright Technophobia Ltd 2012
 *
 *   This file is part of Substeps.
 *
 *    Substeps is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    Substeps is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with Substeps.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.technophobia.webdriver.substeps.runner;

import com.technophobia.substeps.execution.node.IExecutionNode;
import com.technophobia.substeps.runner.IExecutionListener;
import com.technophobia.substeps.runner.MutableSupplier;
import com.technophobia.webdriver.util.WebDriverContext;

/**
 * 
 * @author imoore
 * 
 */
public class TestFailureListener implements IExecutionListener {

    private final MutableSupplier<WebDriverContext> webDriverContextSupplier;

    public TestFailureListener(final MutableSupplier<WebDriverContext> webDriverContextSupplier) {
        super();
        this.webDriverContextSupplier = webDriverContextSupplier;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.technophobia.substeps.runner.INotifier#notifyTestFailed(com.technophobia
     * .substeps.execution.ExecutionNode, java.lang.Throwable)
     */
    public void onNodeFailed(final IExecutionNode arg0, final Throwable arg1) {

        final WebDriverContext webDriverContext = this.webDriverContextSupplier.get();
        // possible to have a failure before the webdrivercontext has been
        // initialised - missing ' default.webdriver.timeout.secs' property for
        // example
        if (webDriverContext != null) {
            webDriverContext.setFailed();
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.technophobia.substeps.runner.INotifier#notifyTestFinished(com.
     * technophobia.substeps.execution.ExecutionNode)
     */
    public void onNodeFinished(final IExecutionNode arg0) {
        // no op
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.technophobia.substeps.runner.INotifier#notifyTestStarted(com.technophobia
     * .substeps.execution.ExecutionNode)
     */
    public void onNodeStarted(final IExecutionNode arg0) {
        // no op
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.technophobia.substeps.runner.INotifier#notifyTestIgnored(com.technophobia
     * .substeps.execution.ExecutionNode)
     */
    public void onNodeIgnored(final IExecutionNode node) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.technophobia.substeps.runner.INotifier#addListener(com.technophobia
     * .substeps.runner.INotifier)
     */
    public void addListener(final IExecutionListener listener) {
        // TODO Auto-generated method stub

    }
}
