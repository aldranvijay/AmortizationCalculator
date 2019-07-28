import React, { Component }  from 'react';
import RepaymentOutput  from '../OutputSegment/RepaymentOutput.js';
import PropTypes from 'prop-types';
import Modal from '@material-ui/core/Modal';
import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import axios from 'axios';


const styles = theme => ({
  button: {
    margin: theme.spacing.unit,
    fontSize: 'x-small',
  },
  input: {
    display: 'none',
  },
  inputField:{
     padding: '5px 5px',
     margin: '8px',
     fontFamily: 'Arial, Helvetica, sans-serif',
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

function rand() {
  return Math.round(Math.random() * 20) - 10;
}

function getModalStyle() {
//   const top = 50 + rand();
//   const left = 50 + rand();
  const top = 45;
  const left = 45;
  console.log('top : '+top);
  console.log('left : '+left);
  return {
    top: `${top}%`,
    left: `${left}%`,
    transform: `translate(-${top}%, -${left}%)`,
  };
}


class RepaymentInput extends Component{
    constructor(props){
        super(props);
        this.state = {
            isOpen: false,
            schedules: [],
            info: 'Provide input to generate the repayment !',
            details: null
            };
        this.generateAmortization = this.generateAmortization.bind(this);
     }


    handleClose(){
        this.setState({ isOpen: false });
    };


    generateAmortization(ev){
        ev.preventDefault();
        var data = {
        	loan_amount: this.LoanAmount.value,
        	emi_draw_on: String(this.EMIDrawOn.value),
	        disbursement_amount: this.DisbursementAmount.value,
	        sanction_amount: this.SanctionedAmount.value,
	        tenor: this.TenorInMonths.value,
	        rate_annual_percent: this.RateAnnualPercentage.value,
	        repsch_type: String(this.RepSchType.value),
	        intrate_basis: String(this.IntRateBasis.value),
	        days_per_month: String(this.DaysPerMonth.value),
	        days_per_year: String(this.DaysPerYear.value),
	        interest_type: String(this.InterestType.value),
	        emi_due_date: String(this.EMIDueDate.value),
	        principal_grace: this.PrincipalGrace.value,
	        interest_grace: this.InterestGrace.value,
	        is_capitalize: this.IsCapitalize.value,
	        is_compounding: this.IsCompounding.value
         };
        
            var headers = {}
            axios.post('http://localhost:8080/rv/amortz/generate', data, {headers: headers }).then((response) => {
                     console.log("Response data status >>>>>>>>>>"+response.data.status)
                     if(response.data.status === 'Success'){
                    	 this.setState({
                        	 schedules: response.data.schedules,
                        	 info: 'Repayment generated successfully!'
                         }); 
                     }else{
                    	 this.setState({
                        	 schedules: [],
                        	 info: 'Error in repayment loading - '+response.data.errorMsg
                         }); 
                     }
                     
                     this.handleClose();
              }).catch(error => {
                  alert("Error occured "+error);
              });
    } 

    
    loadInputPanel(){
       const { classes } = this.props;
       //Dummy values already been assined just for conveinince, these can be edit on portal
       var data = {
    		        LoanAmount: "100000",
    		        EMIDrawOn: "DISB-AMOUNT",
                    DisbursementAmount: "100000",
                    SanctionedAmount: "100000",
                    TenorInMonths: "24",
                    RateAnnualPercentage: "10",
                    RepSchType: "Straight Line",
                    IntRateBasis: "Actual",
                    DaysPerMonth: "Actual",
                    DaysPerYear: "360",
                    InterestType: "FIXED-REDUCING",
                    EMIDueDate: "Actual",
                    PrincipalGrace: "0",
                    InterestGrace: "0",
                    IsCapitalize: false,
                    IsCompounding: false
                 };
        var formData =
        <form>
            <div style={{height: window.outerHeight/2, overflowY: 'auto'}}>
            <table style={{width: '98%'}}>
            {
            Object.keys(data).map((key, index) =>
            <tr>
                <td><span style={{fontSize: 'small',fontFamily: 'monospace',color: '#404040',fontWeight: 'bold'}}>{key}</span></td>
                <td>
                <input ref={(ref) => { this[`${key}`] = ref; }} defaultValue={data[key]} style={{border: '0px',padding: '5px 5px 5px',fontSize: 'small',fontFamily: 'monospace',color: '#617bfb', width: '98%'}} />
                </td>
            </tr> 
            )
            }
            </table>
            </div>
            <span>
                <button onClick={this.generateAmortization} style={{padding: '6px 10px',marginLeft: '72%',color: '#2e312e',borderColor: 'rgb(215, 215, 216)', fontFamily:'fantasy', fontSize:'x-small', background:'white'}}>
                        Generate
                </button>
            </span>
          </form>
        this.setState({ 
            isOpen: true,
            details: formData
        });
        
    }


    render() {
        const { classes } = this.props;
        return (
           <div>
               <Grid container justify='center'>
               <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={this.state.isOpen}
                >
                <div style={getModalStyle()} className={classes.paper}>
                    <span>
                    <Button onClick={() => this.handleClose()} style={{marginLeft:'83%', fontSize:'x-small', border: '1px solid #b9c5b9'}}>Close</Button>
                    </span>
                    <span>
                    <Typography variant="h7" id="modal-title" style={{color: '#e0688a', fontFamily: 'monospace'}}>
                    RepaymentInput - 'FIXED-REDUCING' (Edit details)
                    </Typography>
                    </span>
                    {this.state.details}
                </div>
                </Modal>
               <Grid item xs={9} justify='center' style={{marginTop:'5%'}}>
                <Grid container spacing='15px'>
                <Grid key='2' item style={{marginTop:'0px'}}>
                     <Button variant="outlined" color="Primary" onClick={() => this.loadInputPanel()} className={classes.button}>
                        Amortization Input 
                    </Button>
                </Grid>
                <Grid key='seperator' item style={{marginTop:'0px'}}><div style={{padding: '10px 10px 10px'}}>|</div></Grid>
                <p style={{fontSize: 'small', color: 'blue'}}>{this.state.info}</p>
                </Grid>
                <RepaymentOutput raw={this.state.schedules} />
             </Grid>
             </Grid>
           </div>    
   
        );
    }
}


RepaymentInput.propTypes = {
  classes: PropTypes.object.isRequired,
};
export default withStyles(styles)(RepaymentInput);