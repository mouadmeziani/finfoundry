export interface Tag {
    id: number | null;
    name: string | null;
}

export interface Category {
  id: number;
  name: string;
  description: string;
}

export interface Transaction {
  id: number;
  amount: number;
  description: string;
  date: string;
  type: 'expense' | 'income';
  category?: Category;
  tags?: Tag[];
}
