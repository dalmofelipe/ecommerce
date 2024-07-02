import { BrowserRouter, Route, Routes } from "react-router-dom";
import ProductsProvider from "./contexts/ProductsProvider";
import AdminLayout from './layouts/Admin';
import Dashboard from './pages/Dashboard';
import Produtos from "./pages/Produtos";
import Stock from "./pages/Stock";

function App() {
  return (
  <ProductsProvider>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<AdminLayout />}>
          <Route index element={<Dashboard />} />
          <Route path="/" element={<Dashboard />} />
            <Route path='/products' element={<Produtos />} />
          <Route path='/stock' element={<Stock />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </ProductsProvider>
  );
}

export default App;
