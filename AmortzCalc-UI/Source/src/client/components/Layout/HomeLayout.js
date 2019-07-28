import React, { Component }  from 'react';
import RepaymentInput  from '../InputSegment/RepaymentInput.js';
import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Info from '@material-ui/icons/Info';
import Help from '@material-ui/icons/Help';

const styles = theme => ({
  root: {
    flexGrow: 1,
  },
});

class HomeLayout extends Component{

    constructor(props){
        super(props);
        this.state = {};
    }
    
    render() {
        const { classes } = this.props;
        return (
           <div>
           <h4> Amortization Calculator </h4>
           <RepaymentInput />
           <br />
           </div>    
        );
    }
}
export default withStyles(styles)(HomeLayout);