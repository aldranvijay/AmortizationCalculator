import React, { Component }  from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';


const styles = theme => ({
  table: {
    minWidth: '90%',
  },
  row: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.background.default,
    },
  },
  paper: {
    position: 'absolute',
    width: theme.spacing.unit * 50,
    backgroundColor: theme.palette.background.paper,
    boxShadow: theme.shadows[5],
    padding: theme.spacing.unit * 4,
    outline: 'none',
  },
});

const CustomTableCell = withStyles(theme => ({
  head: {
    backgroundColor: '#2e804e',
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 12,
  },
}))(TableCell);

class RepaymentOutput extends Component{
    constructor(props){
        super(props);
        this.state = {
           details: this.props.raw.schedules
        };
     }

    render() {
        const { classes } = this.props;
        return (
           <div>
             <Grid container justify='center'>
               <Grid item xs={12} justify='center' style={{marginTop:'2%', overflow: 'auto',height: '400px'}}>
                    <Table className={classes.table}>
                           <TableHead>
                           <TableRow>
	                           <CustomTableCell>InstNo</CustomTableCell>
	                           <CustomTableCell >EMIDueDate </CustomTableCell>
	                           <CustomTableCell >EMI </CustomTableCell>
	                           <CustomTableCell >Interest </CustomTableCell>
	                           <CustomTableCell >Principal </CustomTableCell>
	                           <CustomTableCell>Principal O/S</CustomTableCell>
	                           <CustomTableCell >Days(In Month) </CustomTableCell>
	                           <CustomTableCell >Days(Per Year) </CustomTableCell>
	                           <CustomTableCell >Days(In Month Actual) </CustomTableCell>
	                           <CustomTableCell >Cumulative Days </CustomTableCell>
	                           <CustomTableCell>Discounting factor</CustomTableCell>
	                       </TableRow>
	                       </TableHead>
                           <TableBody>{
                        	   Object.values(this.props.raw).map((data) =>
                               <TableRow>
                               <CustomTableCell>{data.installment_no}</CustomTableCell>
	                           <CustomTableCell >{data.due_date}</CustomTableCell>
	                           <CustomTableCell >{data.emi}</CustomTableCell>
	                           <CustomTableCell >{data.interest}</CustomTableCell>
	                           <CustomTableCell >{data.principal}</CustomTableCell>
	                           <CustomTableCell>{data.principal_os}</CustomTableCell>
	                           <CustomTableCell >{data.days_per_month}</CustomTableCell>
	                           <CustomTableCell >{data.days_per_year}</CustomTableCell>
	                           <CustomTableCell >{data.days_in_month_actual}</CustomTableCell>
	                           <CustomTableCell >{data.cumulative_days_actual}</CustomTableCell>
	                           <CustomTableCell>{data.discounting_factor}</CustomTableCell>
                               </TableRow>
                           )
                           } </TableBody>
                    </Table>
               </Grid>
             </Grid>
           </div>    
   
        );
    }
}


RepaymentOutput.propTypes = {
  classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(RepaymentOutput);