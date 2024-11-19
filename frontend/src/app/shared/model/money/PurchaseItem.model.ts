import {PurchaseDto} from './Purchase.model';
import {ProductDto} from '../catalog/Product.model';

import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PurchaseItemDto extends BaseDto{

    public price: null | number;

    public quantity: null | number;

    public image: string;

    public product: ProductDto ;
    public purchase: PurchaseDto ;


    constructor() {
        super();

        this.price = null;
        this.quantity = null;
        this.image = '';

        }

}
