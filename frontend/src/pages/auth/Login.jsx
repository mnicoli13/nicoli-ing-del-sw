import { Box, TextField, Typography, Container, Tabs, Tab, Button  } from "@mui/material";
import { useState } from "react";

const Login = () => {

  const [activeTab, setActiveTab] = useState(0);
    const [formData, setFormData] = useState({
        email: '',
        password: '',
        confirmPassword: ''
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        if (activeTab === 0) {
            // Handle Sign In
            console.log('Sign In:', formData);
        } else {
            // Handle Register
            console.log('Register:', formData);
        }
    };

  return (
    <Box>
      <Container maxWidth="sm">
            <Box sx={{ mt: 5 }}>
                <Typography variant="h4" align="center">
                    {activeTab === 0 ? 'Sign In' : 'Register'}
                </Typography>
                <Tabs
                    value={activeTab}
                    onChange={(event, newValue) => setActiveTab(newValue)}
                    centered
                >
                    <Tab label="Sign In" />
                    <Tab label="Register" />
                </Tabs>
                <form onSubmit={handleSubmit}>
                    <TextField
                        label="Email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                        required
                    />
                    <TextField
                        label="Password"
                        name="password"
                        type="password"
                        value={formData.password}
                        onChange={handleChange}
                        fullWidth
                        margin="normal"
                        required
                    />
                    {activeTab === 1 && (
                        <TextField
                            label="Confirm Password"
                            name="confirmPassword"
                            type="password"
                            value={formData.confirmPassword}
                            onChange={handleChange}
                            fullWidth
                            margin="normal"
                            required
                        />
                    )}
                    <Button
                        type="submit"
                        variant="contained"
                        color="primary"
                        fullWidth
                        sx={{ mt: 2 }}
                    >
                        {activeTab === 0 ? 'Sign In' : 'Register'}
                    </Button>
                </form>
            </Box>
        </Container>
    </Box>
  );
};

export default Login;
