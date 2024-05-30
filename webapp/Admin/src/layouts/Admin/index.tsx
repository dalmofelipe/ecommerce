import Aside from '../../components/Aside';
import Toolbar from '../../components/Toolbar';
import { Outlet } from "react-router-dom";

import './styles.css';

function AdminLayout() {
  return (
    <div className="App">
      <Aside />

      <Toolbar />

      <Outlet />
    </div>
  );
}

export default AdminLayout;