import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'productscoffee',
})

export class CoffeeProductsPipe implements PipeTransform {
    transform(items: any[]): any {
        // Filtrar o array, items que atendem a condição ficam, os que não são removidos
        let coffeeItems = [];
        for(let i = 0; i< items.length; i++){
            console.log(items[i].type);
            if (items[i].type === 'cafe'){
                coffeeItems.push(items[i]);
            }
        }
        console.log(coffeeItems)
        return coffeeItems;
    }
}