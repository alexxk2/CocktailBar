package com.example.cocktailbar.presentation.creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cocktailbar.R
import com.example.cocktailbar.databinding.FragmentCreationBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class CreationFragment : Fragment() {

    private var _binding: FragmentCreationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CreationViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCancel.setOnClickListener { findNavController().navigateUp() }

        binding.buttonSave.setOnClickListener {

            if (isInputValid()){
                viewModel.addNewCocktail(
                    name = binding.editCocktailName.text.toString(),
                    description = binding.editCocktailDescription.text.toString(),
                    ingredients = binding.editCocktailIngredients.text.toString(),
                    recipe = binding.editCocktailRecipe.text.toString()
                )

                val action = CreationFragmentDirections.actionCreationFragmentToCocktailsFragment()
                findNavController().navigate(action)
            }
            else {
                binding.layoutCocktailName.error = getString(R.string.add_title)
                binding.layoutCocktailIngredients.error = getString(R.string.add_ingredients)
            }
        }

    }

    private fun isInputValid(): Boolean {
        return viewModel.isInputIsValid(
            name = binding.editCocktailName.text.toString(),
            ingredients = binding.editCocktailIngredients.text.toString()
        )
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}